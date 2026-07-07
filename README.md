# Especificação do Projeto - Gestão de Academia

## Introdução

Este documento descreve o escopo inicial do projeto GymFlow. O objetivo do projeto é desenvolver um sistema de gestão para academias, permitindo o gerenciamento eficiente de:

1. Controle de acesso e matrículas:

- Saber quem está ativo, inadimplente ou cancelado.
- Garantir que um aluno só possa ter uma única matrícula ativa por vez. Caso queira alterar de plano, o sistema deve alterar a matrícula existente ou encerrar a matrícula atual e criar uma nova.

2. Controle de Planos:

- Permitir a criação de diferentes planos de assinatura, com preços e benefícios distintos.
- Possibilitar a alteração de planos pelos alunos, respeitando as regras de transição entre planos.

3. Evolução do Aluno:

- Professores devem poder registrar a ficha de treino e acompanhar se o aluno está evoluindo ou não.

# Regras de Negócio (RN)

## Matrículas

1. Ciclo de vida do Aluno:
   - **Pendente**: Aluno que ainda não realizou o pagamento da matrícula.
   - **Ativo**: Aluno com matrícula ativa e em dia.
   - **Inadimplente**: Aluno com matrícula ativa, mas com pagamento atrasado.
   - **Cancelado**: Aluno que encerrou sua matrícula ou teve sua matrícula encerrada.

2. Caso o aluno queira alterar de plano, o sistema vai encerrar a matrícula atual (calculando o proporcional de dias usados, se necessário) e criar uma nova matrícula com o novo plano escolhido. Será mantido o histórico de que o aluno alterou o plano. Seu passado ainda estará registrado, mas ele não poderá ter duas matrículas ativas ao mesmo tempo.

3. Indentificação Unica:

- Cada aluno deve ter um identificador único que será seu CPF, captado no ato da matrícula. Deve-se validar se o CPF é válido e se já existe no banco de dados.

Com base nas regras de negócio acima, segue as regras de negócio detalhadas para cada funcionalidade do sistema.

**-RN-MAT-001 - Unicidade de matrícula ativa**: Um aluno só pode possuir uma matrícula com status ATIVO ou INADIMPLENTE por vez no sistema.

**-RN-MAT-002- Obrigatoriedade de CPF**: É obrigatório o fornecimento de um CPF válido para a realização da matrícula, não sendo permitido o cadastro de alunos sem CPF, com CPF inválido ou com CPF já cadastrado no sistema.

**-RN-MAT-003 - Bloqueio por inadimplência**: O aluno que atingir 5 dias de atraso no pagamento terá seus status alterado para INADIMPLENTE e seu acesso físico/catraca bloqueado automaticamente.

**-RN-MAT-004 - Transição entre planos:** A alteração de um plano para de um aluno exige o encerramento (mudando o status para CANCELADO) da matrícula atual e a criação de uma nova matrícula vinculado ao novo plano escolhido, preservando histórico de registros anteriores.

**-RN-MAT-005 - Histórico de matrículas:** O sistema deve manter um histórico completo das matrículas do aluno, incluindo datas de início e término, status e alterações de plano.

## Controle de Planos

A academia terá toda flexibilidade para criar diferentes planos de assinatura, com Nome (ex.: Plano Black, Plano Fit), Preço, Benefícios (ex.: acesso a todas as aulas coletivas, acesso a piscina, etc.) e Periodicidade (ex.: mensal, trimestral, anual).

Planos não podem ser excluídos do sistema caso haja alunos ativos vinculados a eles. O sistema deve deixar desativar/inativar o plano. Assim quem já tem matrícula vinculada a ele, continuará com o plano ativo, mas novos alunos não poderão se matricular nesse plano.

**-RN-PLA-001 - Controle de planos:** O sistema deve permitir a criação, edição e desativação de planos, garantindo que alunos ativos não sejam afetados por alterações nos planos existentes.

**-RN-PLA-002 - Restrição de exclusão de planos:** Planos não podem ser excluídos do sistema caso haja alunos ativos vinculados a eles.

**-RN-PLA-003 - Histórico de alterações de planos:** O sistema deve manter um histórico completo das alterações de planos, incluindo datas de início e término, status e alterações de benefícios.

**-RN-PLA-004 - Validação de dados de planos:** O sistema deve validar os dados inseridos para a criação e edição de planos, garantindo que informações como preço e periodicidade sejam consistentes e válidas.

**-RN-PLA-005 - Acesso a planos desativados:** Alunos que já possuem matrículas vinculadas a planos desativados devem continuar tendo acesso aos benefícios do plano até o término de sua matrícula, mesmo que o plano não esteja mais disponível para novos alunos.

**-RN-PLA-006 - Notificações de alterações de planos:** O sistema deve notificar os alunos sobre quaisquer alterações nos planos aos quais estão vinculados, garantindo transparência e comunicação eficaz.

## Evolução do Aluno

Para promover agilidade para os professores, entre um aluno e outro, o sistema deverá criar um vinculo obrigatório entre professor e aluno. Uma ficha de treino só faz sentido se estiver vinculada a um aluno e a um professor responsável. Uma ficha de treino tem prazo da validade. Toda ficha ao ser preenchida deverá conter a data de expiração ou limite de execuções (ex.: essa ficha vale por 30 treinos ou até o dia X). Quando vencer, o sistema precisa avisar ao aluno para que agende uma nova ficha de treino com o professor responsável. O professor poderá criar uma nova ficha de treino para o aluno, mas não poderá alterar a ficha de treino anterior, apenas criar uma nova. Alunos só visualizam os seus treinos. Apenas professor e adminstradores podem criar, editar ou excluir as fichas de treinos. Todo histórico de treinos do aluno deve ser mantido no sistema, mesmo que a ficha de treino tenha expirado.

**-RN-TRN-001 - Controle de fichas de treino:** O sistema deve permitir a criação, edição e exclusão de fichas de treino, garantindo que apenas professores e administradores tenham acesso a essas funcionalidades.

**-RN-TRN-002 - Validação de fichas de treino:** O sistema deve validar os dados inseridos para a criação e edição de fichas de treino, garantindo que informações como data de expiração e limite de execuções sejam consistentes e válidas.

**-RN-TRN-003 - Notificações de fichas de treino:** O sistema deve notificar os alunos sobre o vencimento de suas fichas de treino, garantindo que possam agendar novas fichas com o professor responsável.

**-RN-TRN-004 - Histórico de fichas de treino:** O sistema deve manter um histórico completo das fichas de treino dos alunos, incluindo datas de criação, expiração e alterações realizadas pelos professores.

**-RN-TRN-005 - Acesso restrito às fichas de treino:** Alunos só podem visualizar suas próprias fichas de treino, enquanto professores e administradores têm acesso completo para gerenciar as fichas de treino dos alunos.

**-RN-TRN-006 - Vinculação entre professor e aluno:** O sistema deve garantir que cada ficha de treino esteja vinculada a um professor responsável e a um aluno específico, promovendo responsabilidade e acompanhamento adequado do progresso do aluno.

**-RN-TRN-007 - Limite de validade das fichas de treino:** O sistema deve permitir que as fichas de treino tenham um prazo de validade definido, seja por data ou por número de execuções, garantindo que os alunos recebam acompanhamento contínuo e atualizado.

**-RN-TRN-008 - Registro de evolução do aluno:** O sistema deve permitir que os professores registrem a evolução dos alunos com base nas fichas de treino, possibilitando acompanhamento do progresso e ajustes nos treinos conforme necessário.

**-RN-TRN-009 - Relatórios de evolução:** O sistema deve gerar relatórios detalhados sobre a evolução dos alunos, permitindo que professores e administradores analisem o desempenho e façam ajustes nos planos de treino conforme necessário.

**-RN-TRN-010 - Acesso a histórico de evolução:** O sistema deve permitir que alunos acessem seu histórico de evolução, possibilitando que acompanhem seu progresso ao longo do tempo e identifiquem áreas de melhoria.

**-RN-TRN-011 - Unicidade de fichas de treino:** Um aluno só pode ter uma ficha de treino ativa por vez. Caso o professor queira criar uma nova ficha, a ficha anterior deve ser encerrada ou expirada, mantendo o histórico de fichas anteriores para referência futura.

# Casos de Uso (UC)

## Matrículas

- Caso de Uso: UC-MAT-001 - Realizar Matrícula
  - Ator Principal: Recpcionista / Administrador
  - Pré-condições: O aluno deve fornecer um CPF válido e não estar cadastrado no sistema e o plano desejado pelo aluno deve estar disponível no sistema.
  - Pós-condições: O aluno é cadastrado, sua matrícula é gerada com o status PENDENTE (RN-MAT-001) e o histórico é iniciado (RN-MAT-005).

  - Fluxo Principal (Caminho Feliz):
    1. O/A recepcionista/administrador inicia o processo de nova matrícula no sistema.
    2. O sistema solicita os dados do aluno, incluindo CPF, nome completo, email, telefone, data de nascimento e plano desejado.
    3. O/A recepcionista/administrador insere os dados do aluno no sitema e escolhe o plano desejado.
    4. O sistema valida o formato do CPF, se o email é válido, se o plano escolhido está ativo e se o aluno já possui matrícula ativa (RN-MAT-001, RN-MAT-002).
    5. O sistema valida se o aluno já possui matrícula ativa ou inadimplente (RN-MAT-001).
    6. O sistema salva o cadastro do aluno.
    7. O sistema gera a matrícula do aluno vinculado ao plano escolhido, com status PENDENTE (RN-MAT-001).
    8. O sistema confirma sucesso da operação para o/a recepcionista/administrador e exibe os detalhes da matrícula gerada.
  - Fluxo de exceção:
    - 4º passo - CPF Inválido ou Duplicado:
      1. O sistema identifica que o CPF digitado é inválido ou já pertence a outro aluno cadastrado.
      2. O sistema exibe uma mensagem de erro: "Não foi possível realizar a matrícula: CPF Inválido ou já cadastrado."
      3. O fluxo retorna ao passo 2.

    - 5º passo - Aluno já possui matrícula ativa ou inadimplente:
      1. O sistema identifica que o aluno já possui uma matrícula ativa ou inadimplente.
      2. O sistema exibe uma mensagem de erro: "Não foi possível realizar a matrícula: Aluno já possui matrícula ativa."
      3. O fluxo é abortado.

- Caso de Uso: UC-MAT-002 - Alterar Plano de Matrícula
  - Ator Principal: Recepcionista / Administrador
  - Pré-condições: O aluno deve ter uma matrícula ativa ou inadimplente e o plano desejado pelo aluno deve estar disponível no sistema.
  - Pós-condições: A matrícula atual do aluno é encerrada (status CANCELADO) e uma nova matrícula é criada com o novo plano escolhido, mantendo o histórico de alterações (RN-MAT-004, RN-MAT-005).

  - Fluxo Principal (Caminho Feliz):
    1. O/A recepcionista/administrador inicia o processo de alteração de plano no sistema.
    2. O sistema solicita os dados do aluno, incluindo CPF e plano desejado.
    3. O/A recepcionista/administrador insere os dados do aluno no sistema e escolhe o novo plano desejado.
    4. O sistema valida se o aluno possui uma matrícula ativa ou inadimplente (RN-MAT-001) e se o novo plano escolhido está ativo (RN-PLA-001).
    5. O sistema encerra a matrícula atual do aluno, alterando seu status para CANCELADO (RN-MAT-004), realiza o cálculo do valor proporcional e registra a alteração (RN-MAT-005).
    6. O sistema cria uma nova matrícula para o aluno vinculada ao novo plano escolhido, caso a matrícula anterior tenha status ATIVO, a nova matrícula herdará esse status por dois dias, caso contrário, a nova matrícula terá status PENDENTE (RN-MAT-001).
    7. O sistema confirma sucesso da operação para o/a recepcionista/administrador e exibe os detalhes da nova matrícula gerada.

  - Fluxo de exceção:
    - 4º passo - Aluno não possui matrícula ativa ou inadimplente:
      1. O sistema identifica que o aluno não possui uma matrícula ativa ou inadimplente.
      2. O sistema exibe uma mensagem de erro: "Não foi possível alterar o plano: Aluno não possui matrícula."
      3. O fluxo é abortado.

    - 4º passo - Novo plano não está ativo:
      1. O sistema identifica que o novo plano escolhido não está ativo.
      2. O sistema exibe uma mensagem de erro: "Não foi possível alterar o plano: Novo plano não está disponível."
      3. O fluxo retorna o passo 2.

    - 5º passo - Erro ao encerrar matrícula atual:
      1. O sistema identifica que houve um erro ao tentar encerrar a matrícula atual do aluno.
      2. O sistema exibe uma mensagem de erro: "Não foi possível alterar o plano: Erro ao encerrar matrícula atual."
      3. O fluxo é abortado.

    - 6º passo - Erro ao criar nova matrícula:
      1. O sistema identifica que houve um erro ao tentar criar a nova matrícula para o aluno.
      2. O sistema exibe uma mensagem de erro: "Não foi possível alterar o plano: Erro ao criar nova matrícula."
      3. O fluxo é abortado.

    - 7º passo - Erro ao registrar alteração de plano:
      1. O sistema identifica que houve um erro ao tentar registrar a alteração de plano no histórico.
      2. O sistema exibe uma mensagem de erro: "Não foi possível alterar o plano: Erro ao registrar alteração de plano."
      3. O fluxo é abortado.

- Caso de Uso: UC-MAT-003 - Consultar Histórico de Matrículas
  - Ator Principal: Aluno / Recepcionista / Administrador
  - Pré-condições: O aluno deve estar cadastrado no sistema.
  - Pós-condições: O sistema exibe o histórico completo das matrículas do aluno, incluindo datas de início e término, status e alterações de plano (RN-MAT-005).

  - Fluxo Principal (Caminho Feliz):
    1. O ator inicia o processo de consulta do histórico de matrículas no sistema.
    2. O sistema solicita os dados do aluno, incluindo CPF.
    3. O ator insere os dados do aluno no sistema.
    4. O sistema valida se o aluno está cadastrado no sistema.
    5. O sistema exibe o histórico completo das matrículas do aluno, incluindo datas de início e término, status e alterações de plano.

  - Fluxo de exceção:
    - 4º passo - Aluno não cadastrado:
      1. O sistema identifica que o aluno não está cadastrado no sistema.
      2. O sistema exibe uma mensagem de erro: "Não foi possível consultar o histórico: Aluno não cadastrado."
      3. O fluxo é abortado.

- Caso de Uso: UC-MAT-004 - Processar inadimplência diaria
  - Ator Principal: Sistema
  - Pré-condições: O sistema deve estar configurado para processar inadimplência diariamente.
  - Pós-condições: O sistema verifica as matrículas ativas e atualiza o status para INADIMPLENTE caso o aluno esteja com pagamento atrasado por mais de 5 dias, bloqueando o acesso físico/catraca (RN-MAT-003).

  - Fluxo Principal (Caminho Feliz):
    1. O sistema inicia o processo de verificação diária de inadimplência.
    2. O sistema consulta todas as matrículas ativas no banco de dados.
    3. Para cada matrícula ativa, o sistema verifica a data do último pagamento.
    4. Se a data do último pagamento for superior a 5 dias, o sistema altera o status da matrícula para INADIMPLENTE (RN-MAT-003).
    5. O sistema bloqueia automaticamente o acesso físico/catraca do aluno com matrícula inadimplente.
    6. O sistema registra a alteração de status no histórico da matrícula.

  - Fluxo de exceção:
    - 4º passo - Erro ao verificar data do último pagamento:
      1. O sistema identifica que houve um erro ao tentar verificar a data do último pagamento da matrícula.
      2. O sistema exibe uma mensagem de erro: "Não foi possível processar a inadimplência: Erro ao verificar data do último pagamento."
      3. O fluxo é abortado.

    - 5º passo - Erro ao alterar status da matrícula:
      1. O sistema identifica que houve um erro ao tentar alterar o status da matrícula para INADIMPLENTE.
      2. O sistema exibe uma mensagem de erro: "Não foi possível processar a inadimplência: Erro ao alterar status da matrícula."
      3. O fluxo é abortado.

## Controle de Planos

- Caso de Uso: UC-PLA-001 - Criar Plano de Assinatura
  - Ator Principal: Administrador
  - Pré-condições: O administrador deve estar autenticado no sistema.
  - Pós-condições: Um novo plano de assinatura é criado e adicionado ao sistema (RN-PLA-001).

  - Fluxo Principal (Caminho Feliz):
    1. O administrador inicia o processo de criação de um novo plano de assinatura no sistema.
    2. O sistema solicita os dados do plano, incluindo nome, preço, benefícios e periodicidade.
    3. O administrador insere os dados do plano no sistema.
    4. O sistema valida os dados inseridos, garantindo que informações como preço e periodicidade sejam consistentes e válidas (RN-PLA-004).
    5. O sistema salva o novo plano de assinatura no banco de dados.
    6. O sistema confirma sucesso da operação para o administrador e exibe os detalhes do novo plano criado.

  - Fluxo de exceção:
    - 4º passo - Dados inválidos:
      1. O sistema identifica que os dados inseridos para o plano são inválidos ou inconsistentes.
      2. O sistema exibe uma mensagem de erro: "Não foi possível criar o plano: Dados inválidos."
      3. O fluxo retorna ao passo 2.
    - 5º passo - Erro ao salvar plano:
      1. O sistema identifica que houve um erro ao tentar salvar o novo plano de assinatura no banco de dados.
      2. O sistema exibe uma mensagem de erro: "Não foi possível criar o plano: Erro ao salvar no banco de dados."
      3. O fluxo é abortado.
    - 6º passo - Erro ao exibir detalhes do plano:
      1. O sistema identifica que houve um erro ao tentar exibir os detalhes do novo plano criado.
      2. O sistema exibe uma mensagem de erro: "Não foi possível exibir os detalhes do plano: Erro ao recuperar informações."
      3. O fluxo é abortado.

- Caso de Uso: UC-PLA-002 - Editar Plano de Assinatura
  - Ator Principal: Administrador
  - Pré-condições: O administrador deve estar autenticado no sistema e o plano a ser editado deve estar ativo.
  - Pós-condições: O plano de assinatura é atualizado com as novas informações fornecidas pelo administrador (RN-PLA-001, RN-PLA-004).

  - Fluxo Principal (Caminho Feliz):
    1. O administrador inicia o processo de edição de um plano de assinatura existente no sistema.
    2. O sistema solicita os dados do plano a ser editado, incluindo nome, preço, benefícios e periodicidade.
    3. O administrador insere as novas informações do plano no sistema.
    4. O sistema valida os dados inseridos, garantindo que informações como preço e periodicidade sejam consistentes e válidas (RN-PLA-004).
    5. O sistema atualiza o plano de assinatura no banco de dados com as novas informações.
    6. O sistema confirma sucesso da operação para o administrador e exibe os detalhes atualizados do plano.

  - Fluxo de exceção:
    - 4º passo - Dados inválidos:
      1. O sistema identifica que os dados inseridos para o plano são inválidos ou inconsistentes.
      2. O sistema exibe uma mensagem de erro: "Não foi possível editar o plano: Dados inválidos."
      3. O fluxo retorna ao passo 2.
    - 5º passo - Erro ao atualizar plano:
      1. O sistema identifica que houve um erro ao tentar atualizar o plano de assinatura no banco de dados.
      2. O sistema exibe uma mensagem de erro: "Não foi possível editar o plano: Erro ao atualizar no banco de dados."
      3. O fluxo é abortado.
    - 6º passo - Erro ao exibir detalhes do plano:
      1. O sistema identifica que houve um erro ao tentar exibir os detalhes atualizados do plano.
      2. O sistema exibe uma mensagem de erro: "Não foi possível exibir os detalhes do plano: Erro ao recuperar informações."
      3. O fluxo é abortado.

- Caso de Uso: UC-PLA-003 - Desativar Plano de Assinatura
  - Ator Principal: Administrador
  - Pré-condições: O administrador deve estar autenticado no sistema e o plano a ser desativado deve estar ativo.
  - Pós-condições: O plano de assinatura é desativado, impedindo novos alunos de se matricularem nesse plano, mas mantendo o acesso para alunos já matriculados (RN-PLA-002, RN-PLA-005).

  - Fluxo Principal (Caminho Feliz):
    1. O administrador inicia o processo de desativação de um plano de assinatura existente no sistema.
    2. O sistema solicita a confirmação da desativação do plano.
    3. O administrador confirma a desativação do plano.
    4. O sistema verifica se há alunos ativos vinculados ao plano (RN-PLA-002).
    5. Se não houver alunos ativos, o sistema altera o status do plano para desativado.
    6. O sistema confirma sucesso da operação para o administrador e exibe os detalhes do plano desativado.

  - Fluxo de exceção:
    - 4º passo - Alunos ativos vinculados ao plano:
      1. O sistema identifica que há alunos ativos vinculados ao plano.
      2. O sistema exibe uma mensagem de erro: "Não foi possível desativar o plano: Existem alunos ativos vinculados a este plano."
      3. O fluxo é abortado.
    - 5º passo - Erro ao alterar status do plano:
      1. O sistema identifica que houve um erro ao tentar alterar o status do plano para desativado.
      2. O sistema exibe uma mensagem de erro: "Não foi possível desativar o plano: Erro ao atualizar status no banco de dados."
      3. O fluxo é abortado.

- Caso de Uso: UC-PLA-004 - Consultar Histórico de Alterações de Planos
  - Ator Principal: Administrador
  - Pré-condições: O administrador deve estar autenticado no sistema.
  - Pós-condições: O sistema exibe o histórico completo das alterações de planos, incluindo datas de início e término, status e alterações de benefícios (RN-PLA-003).

  - Fluxo Principal (Caminho Feliz):
    1. O administrador inicia o processo de consulta do histórico de alterações de planos no sistema.
    2. O sistema solicita os dados do plano a ser consultado.
    3. O administrador insere os dados do plano no sistema.
    4. O sistema valida se o plano está cadastrado no sistema.
    5. O sistema exibe o histórico completo das alterações do plano, incluindo datas de início e término, status e alterações de benefícios.

  - Fluxo de exceção:
    - 4º passo - Plano não cadastrado:
      1. O sistema identifica que o plano não está cadastrado no sistema.
      2. O sistema exibe uma mensagem de erro: "Não foi possível consultar o histórico: Plano não cadastrado."
      3. O fluxo é abortado.

- Caso de Uso: UC-PLA-005 - Notificar Alunos sobre Alterações de Planos
  - Ator Principal: Sistema / Administrador
  - Pré-condições: O administrador deve estar autenticado no sistema e o plano alterado deve ter alunos ativos vinculados.
  - Pós-condições: Os alunos vinculados ao plano alterado são notificados sobre as alterações realizadas (RN-PLA-006).

  - Fluxo Principal (Caminho Feliz):
    1. O administrador realiza alterações em um plano de assinatura existente no sistema.
    2. O sistema identifica os alunos ativos vinculados ao plano alterado.
    3. O sistema envia notificações aos alunos informando sobre as alterações realizadas no plano.

  - Fluxo de exceção:
    - 2º passo - Nenhum aluno ativo vinculado ao plano:
      1. O sistema identifica que não há alunos ativos vinculados ao plano alterado.
      2. O fluxo é encerrado sem envio de notificações.

- Caso de Uso: UC-PLA-006 - Acesso a Planos Desativados
  - Ator Principal: Aluno
  - Pré-condições: O aluno deve ter uma matrícula ativa vinculada a um plano desativado.
  - Pós-condições: O aluno continua tendo acesso aos benefícios do plano desativado até o término de sua matrícula (RN-PLA-005).

  - Fluxo Principal (Caminho Feliz):
    1. O aluno acessa o sistema para verificar os detalhes de seu plano de assinatura.
    2. O sistema identifica que o aluno possui uma matrícula ativa vinculada a um plano desativado.
    3. O sistema exibe os detalhes do plano desativado, incluindo benefícios e informações relevantes, garantindo que o aluno continue tendo acesso aos benefícios até o término de sua matrícula.

  - Fluxo de exceção:
    - 2º passo - Matrícula não vinculada a plano desativado:
      1. O sistema identifica que o aluno não possui uma matrícula ativa vinculada a um plano desativado.
      2. O sistema exibe uma mensagem de erro: "Não foi possível acessar o plano: Matrícula não vinculada a plano desativado."
      3. O fluxo é abortado.

## Evolução do Aluno

- Caso de Uso: UC-TRN-001 - Criar Ficha de Treino
  - Ator Principal: Professor / Administrador
  - Pré-condições: O professor deve estar autenticado no sistema e o aluno deve ter uma matrícula ativa.
  - Pós-condições: Uma nova ficha de treino é criada e vinculada ao aluno e ao professor responsável, com prazo de validade definido (RN-TRN-001, RN-TRN-007).

  - Fluxo Principal (Caminho Feliz):
    1. O professor inicia o processo de criação de uma nova ficha de treino no sistema.
    2. O sistema solicita os dados da ficha de treino, incluindo exercícios, séries, repetições, data de expiração ou limite de execuções.
    3. O professor insere os dados da ficha de treino no sistema.
    4. O sistema valida os dados inseridos, garantindo que informações como data de expiração e limite de execuções sejam consistentes e válidas (RN-TRN-002).
    5. O sistema salva a nova ficha de treino no banco de dados, vinculando-a ao aluno e ao professor responsável.
    6. O sistema confirma sucesso da operação para o professor e exibe os detalhes da nova ficha de treino criada.

  - Fluxo de exceção:
    - 4º passo - Dados inválidos:
      1. O sistema identifica que os dados inseridos para a ficha de treino são inválidos ou inconsistentes.
      2. O sistema exibe uma mensagem de erro: "Não foi possível criar a ficha de treino: Dados inválidos."
      3. O fluxo retorna ao passo 2.
    - 5º passo - Erro ao salvar ficha:
      1. O sistema identifica que houve um erro ao tentar salvar a nova ficha de treino no banco de dados.
      2. O sistema exibe uma mensagem de erro: "Não foi possível criar a ficha de treino: Erro ao salvar no banco de dados."
      3. O fluxo é abortado.
    - 6º passo - Erro ao exibir detalhes da ficha:
      1. O sistema identifica que houve um erro ao tentar exibir os detalhes da nova ficha de treino criada.
      2. O sistema exibe uma mensagem de erro: "Não foi possível exibir os detalhes da ficha: Erro ao recuperar

  Ajustar

  Aluno (Student)

* id (UUID)
* nome (String)
* CPF (String - Único e Validado)
* email (String)
* telefone (String)
* dataCadastro (LocalDateTime - Registra quando ele entrou no sistema)]
* dataUltimaAtualizacao (LocalDateTime)
* endereco (Value Object - Endereço do aluno)
  - rua (String)
  - numero (String)
  - bairro (String)
  - cidade (String)
  - estado (String)
  - cep (String)

Matrícula (Enrollment)

- id (UUID)
- studentId (UUID - Referência ao Aluno)
- planId (UUID - Referência ao Plano)
- dataInicio (LocalDate - Data de início da matrícula)
- dataFim (LocalDate - Calculada com base na periodicidade do plano)
- status (Enum - PENDENTE, ATIVO, INADIMPLENTE, CANCELADO)
- motivoCancelamento (String - Opcional, apenas se o status for CANCELADO)
- dataCriacao (LocalDateTime - Registra quando a matrícula foi criada)
- dataUltimaAtualizacao (LocalDateTime - Registra a última atualização da matrícula)

Histórico de Matrículas (EnrollmentHistory)

- id (UUID)
- enrollmentId (UUID - Referência à Matrícula)
- statusAnterior (Enum - PENDENTE, ATIVO, INADIMPLENTE, CANCELADO)
- statusAtual (Enum - PENDENTE, ATIVO, INADIMPLENTE, CANCELADO)
- planoAnterior (UUID - Referência ao Plano anterior, se houver)
- planoAtual (UUID - Referência ao Plano atual)
- dataAlteracao (LocalDateTime - Registra quando a alteração ocorreu)
- justificativa (String - Opcional, apenas se houver uma justificativa para a alteração)

Plano (Plan)

- id (UUID)
- nome (String)
- descricao (String)
- periodicidade (Enum - MENSAL, TRIMESTRAL, SEMESTRAL, ANUAL)
- preço (BigDecimal - Valor do plano)
- dataCriacao (LocalDateTime - Registra quando o plano foi criado)
- dataUltimaAtualizacao (LocalDateTime - Registra a última atualização do plano)
- status (Enum - ATIVO, INATIVO)
- beneficioId (List<UUID> - Referência ao Benefício associado ao plano, se houver)

Benefício (Benefit)

- id (UUID)
- nome (String)
- descricao (String)
- dataCriacao (LocalDateTime - Registra quando o benefício foi criado)
- dataUltimaAtualizacao (LocalDateTime - Registra a última atualização do benefício)
- status (Enum - ATIVO, INATIVO)

Professor (Instructor)

- id (UUID)
- nome (String)
- telefone (String)
- email (String)
- especialidade (String)
- dataCriacao (LocalDateTime - Registra quando o professor foi criado)
- dataUltimaAtualizacao (LocalDateTime - Registra a última atualização do professor)
- status (Enum - ATIVO, INATIVO)

Ficha de Treino (TrainingSheet)

- id (UUID)
- studentId (UUID - Referência ao Aluno)
- instructorId (UUID - Referência ao Professor)
- dataCriacao (LocalDateTime - Registra quando a ficha de treino foi criada)
- dataUltimaAtualizacao (LocalDateTime - Registra a última atualização da ficha de treino)
- status (Enum - ATIVO, INATIVO)
- validade (LocalDate - Data de validade da ficha de treino)
- exercicios (List<Exercise> - Lista de exercícios associados à ficha de treino)
- objetivo (String - Objetivo da ficha de treino, como "Hipertrofia", "Emagrecimento", etc.)
- observacoes (String - Observações adicionais sobre a ficha de treino)
- frequenciaTreino (Enum - DIARIO, SEMANAL, MENSAL - Frequência recomendada para o treino)
- nivelDificuldade (Enum - INICIANTE, INTERMEDIARIO, AVANCADO - Nível de dificuldade da ficha de treino)

Exercício (Exercise)

- id (UUID)
- nome (String)
- descricao (String)
- series (Integer - Número de séries recomendadas)
- repeticoes (Integer - Número de repetições recomendadas)
- descanso (Integer - Tempo de descanso entre séries em segundos)
- equipamento (String - Equipamento necessário para o exercício, se houver)
- nivelDificuldade (Enum - INICIANTE, INTERMEDIARIO, AVANCADO - Nível de dificuldade do exercício)
- dataCriacao (LocalDateTime - Registra quando o exercício foi criado)
- dataUltimaAtualizacao (LocalDateTime - Registra a última atualização do exercício)
- status (Enum - ATIVO, INATIVO)
- categoria (Enum - CARDIO, FORCA, FLEXIBILIDADE, EQUILIBRIO - Categoria do exercício)
- objetivo (String - Objetivo do exercício, como "Fortalecimento", "Alongamento", etc.)
- videoUrl (String - URL de um vídeo demonstrativo do exercício, se houver)

{
"name": "String",
"cpf": "String",
"email": "String",
"phone": "String",
"address": {
"street": "String",
"number": "String",
"complement": "String",
"neighborhood": "String",
"city": "String",
"state": "String",
"zipCode": "String"
},
"enrollment": {
"planId": "String"
}
}https://drawsql.app/draw
