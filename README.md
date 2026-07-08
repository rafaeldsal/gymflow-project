# GymFlow - Documentação Oficial v2.0

* [1. Visão do Produto](#visão-do-produto)
* [2. Regras de Negócio](#regras-de-negócio)
  * [2.1 Alunos](#alunos)
  * [2.2 Matrículas](#matrículas)
  * [2.3 Planos e Benefícios](#planos)
  * [2.4 Professores](#professores)
  * [2.5 Treinos](#treinos)
  * [2.6 Notificações](#notificações)
* [3. Casos de Uso](#casos-de-uso)
  * [3.1 Alunos](#alunos)
  * [3.2 Matrículas](#matrículas)
  * [3.3 Planos](#planos)
  * [3.4 Benefícios](#benefícios)
  * [3.5 Professores](#professores)
  * [3.6 Ficha de Treinos](#treinos)
* [4. Arquitetura do Sistema](#arquitetura-do-sistema)
  * [4.1 Visão Geral](#visão-geral)
  * [4.2 Princípios Arquiteturais](#princípios-arquiteturais)
  * [4.3 Camadas do Sistema](#camadas-do-sistema)
  * [4.4 Bounded Contexts](#bounded-contexts)
  * [4.5 Comunicação entre Bounded Contexts](#comunicação-entre-bounded-contexts)
  * [4.6 Eventos de Domínio](#eventos-de-domínio)
  * [4.7 Fluxo de Eventos](#fluxo-de-eventos)
  * [4.8 Notificações](#notificações)
  * [4.9 Organização dos Módulos](#organização-dos-módulos)
  * [4.10 Decisões Arquiteturais](#decisões-arquiteturais)
  * [4.11 Diagrama de contextos](#diagrama-de-contextos)
* [5. Modelo de Domínio](#modelo-de-domínio)
  * [5.1 Visão Geral](#visão-geral)
  * [5.2 Agregados do Domínio](#agregados-do-domínio)
  * [5.3 Entidades do Domínio](#entidades-do-domínio)
  * [5.4 Relacionamentos](#relacionamentos)
  * [5.5 Value Objects](#value-objects)
  * [5.6 Invariantes do Domínio](#invariantes-do-domínio)
* [6. Eventos de Domínio](#eventos-de-domínio)
  * [6.1 Visão Geral](#visão-geral)
  * [6.2 Objetivos](#objetivos)
  * [6.3 Fluxo Geral](#fluxo-geral)
  * [6.4 Eventos do Contexto de Alunos](#eventos-do-contexto-de-alunos)
  * [6.5 Eventos do Contexto de Matrículas](#eventos-do-contexto-de-matrículas)
  * [6.6 Eventos do Contexto de Planos](#eventos-do-contexto-de-planos)
  * [6.7 Eventos do Contexto de Professores](#eventos-do-contexto-de-professores)
  * [6.8 Eventos do Contexto de Treinos](#eventos-do-contexto-de-treinos)
  * [6.9 Eventos Futuros](#eventos-futuros)
  * [6.10 Comunicação entre Contextos](#comunicação-entre-contextos)
  * [6.11 Diretrizes para Criação de Eventos](#diretrizes-para-criação-de-eventos)
* [7. Notificações](#notificações)
  * [7.1 Visão Geral](#visão-geral)
  * [7.2 Objetivos](#objetivos)
  * [7.3 Arquitetura](#arquitetura)
  * [7.4 Fluxo de Funcionamento](#fluxo-de-funcionamento)
  * [7.5 Eventos Consumidos](#eventos-consumidos)
  * [7.6 Canais de Comunicação](#canais-de-comunicação)
  * [7.7 Template de Notificações](#template-de-notificações)
  * [7.8 Falhas no Envio](#falhas-no-envio)
  * [7.9 Extensibilidade](#extensibilidade)
  * [7.10 Responsabilidades do Módulo](#responsabilidades-do-módulo)
  * [7.11 Decisões Arquiteturais](#decisões-arquiteturais)
* [8. APIs REST](#apis-rest)
  * [8.1 Visão Geral](#visão-geral)
  * [8.2 Convenções Gerais](#convenções-gerais)
  * [8.3 Students API](#students-api)
  * [8.4 Enrollments API](#enrollments-api)
  * [8.5 Plans API](#plans-api)
  * [8.6 Benefits API](#benefits-api)
  * [8.7 Trainings API](#trainings-api)
  * [8.8 Professors API](#professors-api)
  * [8.9 Códigos HTTP](#códigos-http)
  * [8.10 Princípios adotados](#princípios-adotados)
* [9. Modelo de Dados](#modelo-de-dados)
  * [9.1 Visão Geral](#visão-geral)
  * [9.2 Convenções de Modelagem](#convenções-de-modelagem)
  * [9.3 Entidades](#entidades)
  * [9.4 Relacionamentos](#relacionamentos)
  * [9.5 Restrições de Integridade](#restrições-de-integridade)
  * [9.6 Estratégia de Persistência](#estratégia-de-persistência)
  * [9.7 Índices Recomendados](#índices-recomendados)
* [10. Roadmap](#roadmap)

## 1. Visão do Produto

### 1.1 Objetivo do GymFlow
O GymFlow é um sistema de gestão para academias desenvolvido com foco em controle de matrículas, gestão de planos, acompanhamento de treinos e evolução dos alunos, permitindo que academias de pequeno e médio porte centralizem suas operações em uma única plataforma.
  * O sistema busca resolver problemas comuns enfrentados por academias, como:
  * controle manual de alunos ativos e inadimplentes;
  * dificuldade em acompanhar mudanças de plano;
  * falta de histórico de matrículas;
  * controle inadequado de fichas de treino;
  * baixa visibilidade da evolução dos alunos;
  * comunicação ineficiente entre academia, professores e alunos.

---
### 1.2 Público-Alvo
O GymFlow é destinado a:
  * academias de pequeno e médio porte;
  * estúdios de treinamento;
  * personal trainers com equipe;
  * redes de academias com múltiplas unidades (evolução futura).

### 1.3 Escopo do MVP
A primeira versão do GymFlow (MVP) focará em funcionalidades essenciais para gestão de alunos, planos e treinos, incluindo:

  * Cadastro de alunos;
  * Controle de matrículas;
  * Alteração de planos;
  * Controle de inadimplência;
  * Cadastro de planos e benefícios;
  * Cadastro de Professores;
  * Criação de fichas de treinos personalizadas;
  * Históricos de treinos;
  * Notificação de vencimento de treino;
  * API REST para integração futura com aplicativos e catracas.

### 1.4 Fora do Escopo do MVP
  * Integração com sistemas de pagamento;
  * Integração com catracas físicas;
  * Aplicativo mobile para alunos;
  * Controle financeiro completo;
  * Agenda de alunos;
  * Avaliações físicas;
  * Business Intelligence (BI) e relatórios avançados;
  * Multi-unidade (para redes de academias);
  * WhatsApp Business API para comunicação com alunos; 

## 2. Regras de Negócio

As regras de negócio descritas nesta seção representam as restrições e comportamentos obrigatórios do domínio do GymFlow. Todas as funcionalidades do sistema deverão respeitar essas regras independentemente da interface utilizada (API REST, aplicação web, aplicativo móvel ou integrações futuras).

### 2.1 Alunos
O aluno representa a pessoa que utiliza os serviços da academia. Seu cadastro é permanente dentro do sistema, independentemente da existência de uma matrícula ativa.

#### RN-ALU-001: Identificador do Aluno
  * Cada aluno deve possuir um identificador único (UUID), gerado automaticamente pelo sistema no momento do cadastro.

#### RN-ALU-002: CPF único
  * O CPF é obrigatório para o cadastro de um aluno.
  * O sistema deve validar:
    * formato do CPF;
    * dígitos verificadores;
    * unicidade.
  * Não será permitido cadastrar dois alunos utilizando o mesmo CPF.

#### RN-ALU-003: Permanência do cadastro
  * O cadastro do aluno nunca será removido em decorrência do cancelamento de uma matrícula.
  * O aluno continuará existindo no sistema para preservar seu histórico.

#### RN-ALU-004: Atualização cadastral
  * Dados cadastrais poderão ser atualizados a qualquer momento, exceto o CPF.
  * Caso seja necessário uma correção no CPF por motivos legais, essa alteração deverá ser realizada exclusivamente por um administrador do sistema.

### 2.2 Matrículas
A matrícula representa o vínculo entre um aluno e um plano de assinatura.

Todas as regras relacionadas ao acesso do aluno à academia pertencem à matrícula e não ao cadastro do aluno.

#### RN-MAT-001: Matrícula única ativa
  * Um aluno poderá possuir apenas uma matrícula com status ATIVA ou INADIMPLENTE por vez.

#### RN-MAT-002: Criação de matrícula
  * Toda matrícula deverá estar obrigatoriamente vinculada:
    * a um aluno;
    * a um plano de assinatura.
  * Não será permitido criar matrículas sem essas associações.

#### RN-MAT-003: Status inicial
  * Toda nova matrícula será criada com status PENDENTE, aguardando confirmação do pagamento inicial.

#### RN-MAT-004: Ativação da matrícula
  * Após a confirmação do pagamento, o status da matrícula deverá ser alterado para ATIVA.

#### RN-MAT-005: Alteração de plano
  * A alteração de plano nunca modificará uma matrícula existente.
  * O sistema deverá:
    * cancelar a matrícula atual;
    * registrar sua data de encerramento;
    * calcular eventuais créditos ou valores proporcionais;
    * criar uma nova matrícula vinculada ao novo plano.
  * Essa regra garante a preservação do histórico de matrículas do aluno.

#### RN-MAT-006: Histórico de matrículas
  * O histórico de matrículas será representado pelo conjunto de matrículas já existentes para o aluno.
  * Não haverá uma entidade específica para histórico de matrículas.

#### RN-MAT-007: Cancelamento de matrícula
  * O cancelamento de uma matrícula encerrará apenas aquele vínculo entre aluno e plano.
  * O cadastro do aluno permanecerá disponível no sistema.

#### RN-MAT-008: Inadimplência
  * Uma matrícula deverá ser considerada inadimplente quando permanecer por mais de cinco dias com pagamento pendente.

#### RN-MAT-009: Bloqueio de acesso
  * Ao tornar-se inadimplente, o sistema deverá bloquear automaticamente o acesso do aluno às dependências da academia por meio da integração com o módulo de controle de acesso.

### 2.3 Planos e Benefícios
Os planos representam os serviços comercializados pela academia.

Cada plano poderá oferecer diferentes benefícios aos alunos.

#### RN-PLA-001: Cadastro de benefícios
  * Os benefícios deverão ser cadastrados previamente no sistema.

#### RN-PLA-002: Associação entre planos e benefícios
  * Um plano poderá possuir zero ou mais benefícios.
  * Um benefício poderá ser reutilizado em diferentes planos.

#### RN-PLA-003: Exclusão de benefícios
  * Benefícios vinculados a planos não poderão ser removidos fisicamente.
  * Caso deixem de ser utilizados, deverão ser desativados.

#### RN-PLA-004: Desativação de planos
  * Planos vinculados a matrículas existentes não poderão ser excluídos.
  * O sistema deverá permitir apenas sua desativação.

#### RN-PLA-005: MAtrículas existentes em planos desativados
  * A desativação de um plano não afetará alunos já matriculados.
  * Essas matrículas permanecerão válidas até seu encerramento.

#### RN-PLA-006: Alteração em planos
  * Alterações em nome, preço ou benefícios de um plano não modificarão automaticamente matrículas já existentes.
  * As regras comerciais da academia definirão quando uma alteração deverá gerar uma nova contratação.

### 2.4 Professores
O professor representa o profissional responsável por ministrar aulas e acompanhar o desempenho dos alunos.

#### RN-PRO-001: Identificador do Professor
  * Cada professor deve possuir um identificador único (UUID), gerado automaticamente pelo sistema no momento do cadastro.

#### RN-PRO-002: CIP único
  * O CIP (Cadastro de Identificação Profissional) é obrigatório para o cadastro de um professor.
  * O sistema deve validar:
    * formato do CIP;
    * unicidade.
  * Não será permitido cadastrar dois professores utilizando o mesmo CIP.

#### RN-PRO-003: Permanência do cadastro
  * O cadastro do professor nunca será removido em decorrência do desligamento da academia.
  * O professor continuará existindo no sistema para preservar seu histórico.

#### RN-PRO-004: Atualização cadastral
  * Dados cadastrais poderão ser atualizados a qualquer momento, exceto o CIP.
  * Caso seja necessário uma correção no CIP por motivos legais, essa alteração deverá ser realizada exclusivamente por um administrador do sistema.

#### RN-PRO-005: Atribuição de treinos
  * O professor poderá ser atribuído a um ou mais treinos.
  * O sistema deverá permitir a associação entre professores e treinos, garantindo que cada treino tenha um responsável.

### 2.5 Treinos
A ficha de treino representa uma prescrição elaborada por um professor para um aluno.

Ela não representa o catálogo de exercícios da academia.

#### RN-TRN-001: Exclusividade da ficha de treino
  * Cada aluno poderá possuir apenas uma ficha de treino ativa por vez.
  * A criação de uma nova ficha de treino deverá desativar a ficha anterior.

#### RN-TRN-002: Atribuição de professor
  * Cada ficha de treino deverá estar obrigatoriamente vinculada a um professor responsável.
  * O sistema deverá permitir a associação entre fichas de treino e professores, garantindo que cada ficha tenha um responsável.

#### RN-TRN-003: Criação de ficha de treino
  * Uma ficha será composta por diversos exercícios prescritos.
  * Cada exercício prescrito armazenará informações como:
    * séries;
    * repetições;
    * carga sugerida;
    * descanso entre séries;
    * observações adicionais.
  * Essas informações pertencem à prescrição, não ao exercício cadastrado.

#### RN-TRN-004: Histórico de treinos
  * O histórico de treinos será representado pelo conjunto de fichas de treino já existentes para o aluno.
  * Não haverá uma entidade específica para histórico de treinos.
  * Fichas expiradas ou desativadas permanecerão disponíveis no sistema para consulta.

#### RN-TRN-005: Validade da ficha de treino
  * O sistema deverá permitir definir a validar por:
    * data de expiração;
    * quantidade máxima de execuções;

#### RN-TRN-006: Acesso à ficha de treino
  * O acesso à ficha de treino será restrito ao aluno e ao professor responsável.
  * O sistema deverá garantir que apenas essas partes possam visualizar ou modificar a ficha.

### 2.6 Notificações
O envio de notificações faz parte do domínio do sistema e será realizado automaticamente através de eventos de negócio.

Não existirão endpoints REST responsáveis pelo disparo manual de notificações.

#### RN-NOT-001: Expiração de ficha de treino
  * Ao expirar uma ficha de treino, o sistema deverá notificar o aluno.

#### RN-NOT-002: Alteração de plano
  * Ao ocorrer alteração de plano, o sistema poderá notificar o aluno sobre a mudança.

#### RN-NOT-003: Inadimplência
  * Ao identificar inadimplência, o sistema deverá comunicar o aluno antes do bloqueio definitivo de acesso.

#### RN-NOT-004: Vencimento de matrícula
  * O sistema deverá notificar o aluno sobre o vencimento da matrícula antes do bloqueio de acesso.

#### RN-NOT-005: Notificações de eventos
  * As notificações deverão ser desacopladas das regras de negócio, sendo executadas através de eventos de domínio e processadas pelo módulo de notificações.

## 3. Casos de Uso

Os Casos de Uso descrevem como cada ator interage com o sistema para atingir um objetivo específico, considerando apenas o comportamento esperado do domínio.

Detalhes de implementação, persistência de dados e infraestrutura não fazem parte desta seção.

### 3.1 Alunos
---
**UC-ALU-001: Cadastrar Aluno**
  * **Objetivo**
    * Cadastrar um novo aluno no sistema para permitir futuras matrículas.
  * **Atores**
    * Recepcionista
    * Administrador
  * **Pré-condições**
    * O aluno ainda não está cadastrado.
    * O CPF do aluno é válido e não está em uso.
  * **Fluxo Principal**
    1. O ator inicia o cadastro de um novo aluno;
    2. O sistema solicita os dados cadastrais;
    3. O ator informa os dados obrigatórios;
    4. O sistema valida o CPF;
    5. O sistema verifica se já existe um aluno com o mesmo CPF;
    6. O sistema registra o aluno.
  * **Fluxos Alternativos**
    * FA-01: CPF Inválido
      * O sistema informa que o CPF é inválido e solicita sua correção.
    * FA-02: CPF já cadastrado
      * O sistema informa que o CPF já está em uso e solicita outro CPF.
  * **Pós-condições**
    * O aluno encontra-se cadastrado e apto para receber uma matrícula.
  * **Regras de Negócio Relacionadas**
    * RN-ALU-001: Identificador do Aluno
    * RN-ALU-002: CPF único
    * RN-ALU-003: Permanência do cadastro
    * RN-ALU-004: Atualização cadastral
---
**UC-ALU-002: Atualizar Cadastro de Aluno**
  * **Objetivo**
    * Permitir a atualização das informações cadastrais de um aluno.
  * **Atores**
    * Recepcionista
    * Administrador
  * **Pré-condições**
    * O aluno já está cadastrado no sistema.
  * **Fluxo Principal**
    1. O ator localiza o aluno.
    2. O sistema apresenta os dados atuais.
    3. O ator realiza as alterações necessárias nos dados do aluno.
    4. O sistema valida os novos dados.
    5. O sistema salva as alterações no cadastro do aluno.
  * **Fluxos Alternativos**
    * FA-01: Aluno não encontrado
      * O sistema informa que o aluno não foi localizado.
  * **Pós-condições**
    * As informações cadastrais permanecem atualizadas.
  * **Regras de Negócio Relacionadas**
    * RN-ALU-004: Atualização cadastral
---

### 3.2 Matrículas
---
**UC-MAT-001: Criar Matrícula**
  * **Objetivo**
    * Vincular um aluno a um plano de assinatura.
  * **Atores**
    * Recepcionista
    * Administrador
  * **Pré-condições**
    * O aluno já está cadastrado no sistema.
    * O plano de assinatura já está cadastrado no sistema e ativo.
    * O aluno não possui uma matrícula ativa ou inadimplente.
  * **Fluxo Principal**
    1. O ator seleciona o aluno.
    2. O sistema apresenta os planos disponíveis.
    3. O ator escolhe o plano desejado.
    4. O sistema cria a matrícula com status ***PENDENTE***.
  * **Fluxos Alternativos**
    * FA-01: Aluno já possui matrícula ativa ou inadimplente
      * O sistema impede a criação da matrícula.
    * FA-02: Plano indisponível ou inativo
      * O sistema informa que o plano não pode ser utilizado.
  * **Pós-condições**
    * Uma nova matrícula é criada.
  * **Regras de Negócio Relacionadas**
    * RN-MAT-001: Matrícula única ativa
    * RN-MAT-002: Criação de matrícula
    * RN-MAT-003: Status inicial
    * RN-MAT-004: Ativação da matrícula
---
**UC-MAT-002: Alterar Plano**
  * **Objetivo**
    * Permitir a alteração do plano de assinatura de uma matrícula existente.
  * **Atores**
    * Recepcionista
    * Administrador
  * **Pré-condições**
    * O aluno já possui uma matrícula ativa.
    * O novo plano de assinatura está cadastrado e ativo.
  * **Fluxo Principal**
    1. O ator seleciona a matrícula do aluno.
    2. O sistema apresenta os planos disponíveis.
    3. O ator escolhe o novo plano desejado.
    4. O sistema encerrará a matrícula atual, registrando sua data de encerramento.
    5. O sistema calcula valores proporcionais ou créditos, se aplicável.
    6. O sistema cria uma nova matrícula vinculada ao novo plano.
  * **Fluxos Alternativos**
    * FA-01: Aluno não possui matrícula ativa
      * O sistema informa que não é possível alterar o plano sem uma matrícula ativa.
    * FA-02: Novo plano indisponível ou inativo
      * O sistema informa que o novo plano não pode ser utilizado.
  * **Pós-condições**
    * A matrícula anterior permanece registrada como encerrada e uma nova matrícula passa a representar o vínculo atual do aluno.
  * **Regras de Negócio Relacionadas**
    * RN-MAT-005: Alteração de plano
    * RN-MAT-006: Histórico de matrículas
---
**UC-MAT-003: Cancelar Matrícula**
  * **Objetivo**
    * Encerrar o vínculo entre aluno e plano.
  * **Atores**
    * Recepcionista
    * Administrador
  * **Pré-condições**
    * O aluno já possui uma matrícula ativa ou inadimplente.
  * **Fluxo Principal**
    1. O ator seleciona a matrícula do aluno.
    2. O sistema solicita a confirmação do cancelamento.
    3. O ator confirma o cancelamento.
    4. O sistema encerra a matrícula, registrando sua data de encerramento.
  * **Fluxos Alternativos**
    * FA-01: Aluno não possui matrícula ativa ou inadimplente
      * O sistema informa que não é possível cancelar uma matrícula inexistente.
  * **Pós-condições**
    * A matrícula é encerrada, o aluno não possui mais vínculo com o plano e o aluno permanece cadastrado.
  * **Regras de Negócio Relacionadas**
    * RN-MAT-007: Cancelamento de matrícula
---
**UC-MAT-004: Processar Inadimplência**
  * **Objetivo**
    * Atualizar automaticamente as matrículas inadimplentes.
  * **Atores**
    * Sistema (automático)
  * **Pré-condições**
    * A matrícula está com pagamento pendente há mais de cinco dias.
  * **Fluxo Principal**
    1. O sistema identifica matrículas com pagamentos em atraso.
    2. O sistema altera o status para ***INADIMPLENTE***.
    3. O sistema bloqueia o acesso do aluno.
    4. O sistema publica um evento de inadimplência para o módulo de notificações.
  * **Pós-condições**
    * A matrícula é marcada como inadimplente, o aluno é notificado e seu acesso é bloqueado.
  * **Regras de Negócio Relacionadas**
    * RN-MAT-008: Inadimplência
    * RN-MAT-009: Bloqueio de acesso
    * RN-NOT-003: Inadimplência
---

### 3.3 Planos
---
**UC-PLA-001: Cadastrar Plano**
  * **Objetivo**
    * Permitir o cadastro de um novo plano de assinatura.
  * **Atores**
    * Administrador
  * **Pré-condições**
    * O plano ainda não está cadastrado no sistema.
  * **Fluxo Principal**
    1. O ator inicia o cadastro de um novo plano.
    2. O sistema solicita os dados do plano.
    3. O ator informa os dados obrigatórios.
    4. O sistema registra o plano.
  * **Pós-condições**
    * O plano encontra-se cadastrado e disponível para futuras matrículas.
  * **Regras de Negócio Relacionadas**
    * RN-PLA-001: Cadastro de benefícios
    * RN-PLA-002: Associação entre planos e benefícios
---
**UC-PLA-002: Alterar Plano**
  * **Objetivo**
    * Permitir a atualização das informações de um plano existente.
  * **Atores**
    * Administrador
  * **Pré-condições**
    * O plano já está cadastrado no sistema.
  * **Fluxo Principal**
    1. O ator seleciona o plano a ser alterado.
    2. O sistema apresenta os dados atuais do plano.
    3. O ator realiza as alterações necessárias.
    4. O sistema atualiza o plano.
  * **Pós-condições**
    * As informações do plano permanecem atualizadas.
  * **Regras de Negócio Relacionadas**
    * RN-PLA-006: Alteração em planos
---
**UC-PLA-003: Desativar Plano**
  * **Objetivo**
    * Permitir a desativação de um plano existente.
  * **Atores**
    * Administrador
  * **Pré-condições**
    * O plano já está cadastrado no sistema.
  * **Fluxo Principal**
    1. O ator seleciona o plano a ser desativado.
    2. O sistema solicita a confirmação da desativação.
    3. O ator confirma a desativação.
    4. O sistema desativa o plano.
  * **Pós-condições**
    * O plano é marcado como inativo e não poderá ser utilizado para novas matrículas.
  * **Regras de Negócio Relacionadas**
    * RN-PLA-004: Desativação de planos
    * RN-PLA-005: Matrículas existentes em planos desativados
---
### 3.4 Benefícios
---
**UC-BEN-001: Cadastrar Benefício**
  * **Objetivo**
    * Permitir o cadastro de um novo benefício.
  * **Atores**
    * Administrador
  * **Pré-condições**
    * O benefício ainda não está cadastrado no sistema.
  * **Fluxo Principal**
    1. O ator inicia o cadastro de um novo benefício.
    2. O sistema solicita os dados do benefício.
    3. O ator informa os dados obrigatórios.
    4. O sistema registra o benefício.
  * **Pós-condições**
    * O benefício encontra-se cadastrado e disponível para associação a planos.
  * **Regras de Negócio Relacionadas**
    * RN-PLA-001: Cadastro de benefícios
---
**UC-BEN-002: Alterar Benefício**
  * **Objetivo**
    * Permitir a atualização das informações de um benefício existente.
  * **Atores**
    * Administrador
  * **Pré-condições**
    * O benefício já está cadastrado no sistema.
  * **Fluxo Principal**
    1. O ator seleciona o benefício a ser alterado.
    2. O sistema apresenta os dados atuais do benefício.
    3. O ator realiza as alterações necessárias.
    4. O sistema atualiza o benefício.
  * **Pós-condições**
    * As informações do benefício permanecem atualizadas.
  * **Regras de Negócio Relacionadas**
    * RN-PLA-001: Cadastro de benefícios
    * RN-PLA-002: Associação entre planos e benefícios
---
**UC-BEN-003: Desativar Benefício**
  * **Objetivo**
    * Permitir a desativação de um benefício existente.
  * **Atores**
    * Administrador
  * **Pré-condições**
    * O benefício já está cadastrado no sistema.
  * **Fluxo Principal**
    1. O ator seleciona o benefício a ser desativado.
    2. O sistema solicita a confirmação da desativação.
    3. O ator confirma a desativação.
    4. O sistema desativa o benefício.
  * **Pós-condições**
    * O benefício é marcado como inativo e não poderá ser utilizado para associação a novos planos.
  * **Regras de Negócio Relacionadas**
    * RN-PLA-003: Exclusão de benefícios
---
**UC-BEN-004: Associar Benefício a Plano**
  * **Objetivo**
    * Permitir a associação de um benefício a um plano existente.
  * **Atores**
    * Administrador
  * **Pré-condições**
    * O benefício e o plano já estão cadastrados no sistema.
  * **Fluxo Principal**
    1. O ator seleciona o plano ao qual deseja associar o benefício.
    2. O sistema apresenta os benefícios disponíveis.
    3. O ator escolhe o benefício desejado.
    4. O sistema associa o benefício ao plano.
  * **Pós-condições**
    * O benefício passa a fazer parte do conjunto de benefícios do plano selecionado.
  * **Regras de Negócio Relacionadas**
    * RN-PLA-002: Associação entre planos e benefícios
---

### 3.5 Professores
---
**UC-PRO-001: Cadastrar Professor**
  * **Objetivo**
    * Permitir o cadastro de um novo professor no sistema.
  * **Atores**
    * Administrador
  * **Pré-condições**
    * O professor ainda não está cadastrado no sistema.
  * **Fluxo Principal**
    1. O ator inicia o cadastro de um novo professor.
    2. O sistema solicita os dados cadastrais.
    3. O ator informa os dados obrigatórios.
    4. O sistema valida o CIP.
    5. O sistema verifica se já existe um professor com o mesmo CIP.
    6. O sistema registra o professor.
  * **Fluxos Alternativos**
    * FA-01: CIP inválido
      * O sistema informa que o CIP é inválido e solicita sua correção.
    * FA-02: CIP já cadastrado
      * O sistema informa que o CIP já está em uso e solicita outro CIP.
  * **Pós-condições**
    * O professor encontra-se cadastrado e apto para ministrar aulas e prescrever treinos.
  * **Regras de Negócio Relacionadas**
    * RN-PRO-001: Identificador do Professor
    * RN-PRO-002: CIP único
    * RN-PRO-003: Permanência do cadastro
    * RN-PRO-004: Atualização cadastral
---
**UC-PRO-002: Atualizar Cadastro de Professor**
  * **Objetivo**
    * Permitir a atualização das informações cadastrais de um professor.
  * **Atores**
    * Administrador
  * **Pré-condições**
    * O professor já está cadastrado no sistema.
  * **Fluxo Principal**
    1. O ator localiza o professor.
    2. O sistema apresenta os dados atuais.
    3. O ator realiza as alterações necessárias nos dados do professor.
    4. O sistema valida os novos dados.
    5. O sistema atualiza o cadastro do professor.
  * **Fluxos Alternativos**
    * FA-01: Professor não encontrado
      * O sistema informa que o professor não foi localizado.
  * **Pós-condições**
    * As informações cadastrais permanecem atualizadas.
  * **Regras de Negócio Relacionadas**
    * RN-PRO-004: Atualização cadastral
---
**UC-PRO-003: Desativar Professor**
  * **Objetivo**
    * Permitir a desativação de um professor existente.
  * **Atores**
    * Administrador
  * **Pré-condições**
    * O professor já está cadastrado no sistema.
  * **Fluxo Principal**
    1. O ator seleciona o professor a ser desativado.
    2. O sistema solicita a confirmação da desativação.
    3. O ator confirma a desativação.
    4. O sistema desativa o professor.
  * **Pós-condições**
    * O professor é marcado como inativo e não poderá ser associado a novos treinos.
  * **Regras de Negócio Relacionadas**
    * RN-PRO-003: Permanência do cadastro
---
**UC-PRO-004: Atribuir Professor a Treino**
  * **Objetivo**
    * Permitir a associação de um professor a um treino existente.
  * **Atores**
    * Administrador
  * **Pré-condições**
    * O professor e o treino já estão cadastrados no sistema.
  * **Fluxo Principal**
    1. O ator seleciona o treino ao qual deseja atribuir o professor.
    2. O sistema apresenta os professores disponíveis.
    3. O ator escolhe o professor desejado.
    4. O sistema associa o professor ao treino.
  * **Pós-condições**
    * O professor passa a ser responsável pelo treino selecionado.
  * **Regras de Negócio Relacionadas**
    * RN-PRO-005: Atribuição de treinos
---

### 3.6 Ficha de Treinos
---
**UC-TRN-001: Criar Ficha de Treino**
  * **Objetivo**
    * Criar uma nova prescrição de treino para um aluno.
  * **Atores**
    * Professor
    * Administrador
  * **Pré-condições**
    * O aluno já possui matrícula ativa.
    * O professor está cadastrado e ativo no sistema.
  * **Fluxo Principal**
    1. O ator seleciona o aluno para o qual deseja criar a ficha de treino.
    2. O sistema apresenta o catalogo de exercícios disponíveis.
    3. O ator adiciona exercícios à ficha.
    4. Para cada exercício adicionado, o ator define:
      * séries;
      * repetições;
      * carga sugerida;
      * descanso entre séries;
      * observações adicionais.
    5. O ator define a validade da ficja.
    6. O sistema encerra automaticamente a ficha anterior, caso exista.
    7. O sistema registra a nova ficha de treino.
  * **Fluxos Alternativos**
    * FA-01: Aluno não possui matrícula ativa
      * O sistema informa que não é possível criar uma ficha de treino sem uma matrícula ativa.
    * FA-02: Professor não cadastrado ou inativo
      * O sistema informa que o professor não pode ser atribuído à ficha de treino.
  * **Pós-condições**
    * Uma nova ficha de treino é criada e associada ao aluno e ao professor responsável.
  * **Regras de Negócio Relacionadas**
    * RN-TRN-001: Exclusividade da ficha de treino
    * RN-TRN-002: Atribuição de professor
    * RN-TRN-003: Criação de ficha de treino
    * RN-TRN-005: Validade da ficha de treino
    * RN-TRN-006: Acesso à ficha de treino
---
**UC-TRN-002: Consultar Ficha de Treino**
  * **Objetivo**
    * Permitir a visualização da ficha de treino de um aluno.
  * **Atores**
    * Professor
    * Aluno
  * **Pré-condições**
    * O aluno possui uma ficha de treino ativa.
    * O professor é responsável pela ficha de treino ou o aluno é o titular da ficha.
  * **Fluxo Principal**
    1. O ator seleciona o aluno cuja ficha deseja consultar.
    2. O sistema verifica se o ator tem permissão para acessar a ficha.
    3. O sistema apresenta os detalhes da ficha de treino, incluindo:
      * exercícios prescritos;
      * séries e repetições;
      * carga sugerida;
      * descanso entre séries;
      * observações adicionais.
  * **Fluxos Alternativos**
    * FA-01: Acesso negado
      * O sistema informa que o ator não tem permissão para acessar a ficha de treino.
    * FA-02: Ficha de treino não encontrada
      * O sistema informa que não existe uma ficha de treino ativa para o aluno selecionado.
  * **Pós-condições**
    * A ficha de treino é exibida ao ator autorizado.
  * **Regras de Negócio Relacionadas**
    * RN-TRN-006: Acesso à ficha de treino
---
**UC-TRN-003: Consultar Histórico de Treinos**
  * **Objetivo**
    * Permitir a visualização do histórico de fichas de treino de um aluno.
  * **Atores**
    * Professor
    * Aluno
  * **Pré-condições**
    * O aluno possui fichas de treino anteriores registradas no sistema.
    * O professor é responsável por alguma das fichas ou o aluno é o titular das fichas.
  * **Fluxo Principal**
    1. O ator seleciona o aluno cujo histórico deseja consultar.
    2. O sistema verifica se o ator tem permissão para acessar o histórico.
    3. O sistema apresenta a lista de fichas de treino anteriores, incluindo:
      * datas de criação e expiração;
      * exercícios prescritos;
      * séries e repetições;
      * carga sugerida;
      * descanso entre séries;
      * observações adicionais.
  * **Fluxos Alternativos**
    * FA-01: Acesso negado
      * O sistema informa que o ator não tem permissão para acessar o histórico de treinos.
    * FA-02: Histórico não encontrado
      * O sistema informa que não existem fichas de treino registradas para o aluno selecionado.
  * **Pós-condições**
    * O histórico de treinos é exibido ao ator autorizado.
  * **Regras de Negócio Relacionadas**
    * RN-TRN-004: Histórico de treinos
---
**UC-TRN-004: Registrar Evolução do Aluno**
  * **Objetivo**
    * Permitir o registro da evolução do aluno em relação à ficha de treino.
  * **Atores**
    * Professor
  * **Pré-condições**
    * O aluno possui uma ficha de treino ativa.
    * O professor é responsável pela ficha de treino.
  * **Fluxo Principal**
    1. O ator seleciona o aluno cuja evolução deseja registrar.
    2. O sistema apresenta a ficha de treino atual.
    3. O ator registra informações sobre a evolução do aluno, incluindo:
      * desempenho nos exercícios;
      * ajustes na carga ou repetições;
      * observações adicionais.
    4. O sistema salva as informações de evolução no histórico do aluno.
  * **Fluxos Alternativos**
    * FA-01: Acesso negado
      * O sistema informa que o ator não tem permissão para registrar a evolução do aluno.
    * FA-02: Ficha de treino não encontrada
      * O sistema informa que não existe uma ficha de treino ativa para o aluno selecionado.
  * **Pós-condições**
    * A evolução do aluno é registrada e associada à sua ficha de treino.
  * **Regras de Negócio Relacionadas**
    * RN-TRN-006: Acesso à ficha de treino
---
**UC-TRN-005: Notificar Expiração de Ficha de Treino**
  * **Objetivo**
    * Notificar automaticamente o aluno sobre a expiração de sua ficha de treino.
  * **Atores**
    * Sistema (automático)
  * **Pré-condições**
    * A ficha de treino do aluno está prestes a expirar ou já expirou.
  * **Fluxo Principal**
    1. O sistema identifica fichas de treino próximas da data de expiração ou já expiradas.
    2. O sistema envia uma notificação ao aluno informando sobre a expiração da ficha.
  * **Pós-condições**
    * O aluno é informado sobre a necessidade de atualizar ou renovar sua ficha de treino.
  * **Regras de Negócio Relacionadas**
    * RN-NOT-001: Expiração de ficha de treino
---

## 4. Arquitetura do Sistema

### 4.1 Visão Geral

O GymFlow será desenvolvido como um Monólito Modular, organizado em módulos de negócio independentes e de baixo acoplamento.

Cada módulo será responsável por um contexto específico do domínio da aplicação, possuindo suas próprias regras de negócio, casos de uso, entidades e interfaces.

Essa organização permite que o sistema evolua de forma incremental, mantendo alta coesão entre os componentes e facilitando testes, manutenção e futuras integrações.

Embora seja um monólito, sua estrutura foi projetada para que determinados módulos possam ser extraídos para microsserviços no futuro, caso haja necessidade.

### 4.2 Princípios Arquiteturais

O GymFlow seguirá os seguintes princípios arquiteturais:

  * **Arquitetura Hexagonal (Ports and Adapters)**;
  * **Domain-Driven Design (DDD)**;
  * **Spring Modulith para modularização interna**;
  * **Baixo acoplamento entre os módulos**;
  * **Alta coesão dentro de cada módulo**;
  * **Comunicação prefencial através de eventos de domínio**;
  * **Separação entre domínio, aplicação e infraestrutura**;
  * **Persistência desacoplada da lógica de negócio**;

### 4.3 Camadas do Sistema

Cada módulo do GymFlow seguirá a mesma organização interna.

```text
┌─────────────────────────────────────────────┐
│               Controllers                   │
│          (REST / API Externa)               │
└─────────────────────────────────────────────┘
                    │
                    ▼
┌─────────────────────────────────────────────┐
│             Application Layer               │
│               Use Cases                     │
└─────────────────────────────────────────────┘
                    │
                    ▼
┌─────────────────────────────────────────────┐
│              Domain Layer                   │
│ Entities                                    │
│ Value Objects                               │
│ Domain Services                             │
│ Domain Events                               │
└─────────────────────────────────────────────┘
                    │
                    ▼
┌─────────────────────────────────────────────┐
│            Infrastructure Layer             │
│ JPA                                         │
│ PostgreSQL                                  │
│ Mensageria                                  │
│ Serviços Externos                           │
└─────────────────────────────────────────────┘
```
A regra principal dessa arquitetura é que o Domínio não conhece nenhuma tecnologia.

Ele não depende de:
  * Spring;
  * Hibernate;
  * PostgreSQL;
  * REST;
  * Mensageria.

### 4.4 Bounded Contexts

O domínio do GymFlow foi dividido em contextos independentes, cada um responsável por um conjunto específico de regras de negócio.

* ### Student Context
  Responsável pelo gerenciamento cadastral dos alunos.

  * **Responsabilidades:**
    * Cadastro de alunos;
    * Atualização de dados cadastrais;
    * Validação de CPF;
    * Consulta de alunos cadastrados;
    * Consulta de histórico de matrículas.

  * **Não é responsável por:**
    * Matrículas;
    * Pagamentos;
    * Treinos.

* ### Enrollment Context
  Responsável pelo gerenciamento das matrículas dos alunos.

  * **Responsabilidades:**
    * Criação de matrículas;
    * Cancelamento;
    * Alteração de planos;
    * Inadimplência;
    * Bloqueio de acesso;
  
  * **Não é responsável por:**
    * Cadastro de alunos;
    * Cadastro de planos;
    * Cadastro de benefícios;
    * Treinos.

  Esse contexto representa o vínculo comercial entre aluno e academia.

* ### Plan Context
  Responsável pelo gerenciamento dos planos comercializados pela academia.

  * **Responsabilidades:**
    * Cadastro de planos;
    * Cadastro de benefícios;
    * Alteração de planos;
    * Exclusão de planos;
    * Precificação de planos;
    * Disponibilidade.

  * **Não é responsável por:**
    * Cadastro de alunos;
    * Matrículas;
    * Pagamentos;
    * Treinos.

* ### Training Context
  Responsável pelo gerenciamento das fichas de treino e acompanhamento do desempenho dos alunos.

  * **Responsabilidades:**
    * Criação de fichas de treino;
    * Atribuição de professores;
    * Registro de evolução do aluno;
    * Consulta de histórico de treinos.

  * **Não é responsável por:**
    * Cadastro de alunos;
    * Matrículas;
    * Pagamentos;
    * Planos e benefícios.
  
* ### Notification Context
  Responsável pelo envio de notificações automáticas aos alunos.

  * **Responsabilidades:**
    * Notificação de expiração de ficha de treino;
    * Notificação de alteração de plano;
    * Notificação de inadimplência;
    * Notificação de vencimento de matrícula.

  * **Não é responsável por:**
    * Cadastro de alunos;
    * Matrículas;
    * Pagamentos;
    * Planos e benefícios;
    * Treinos.

* ### Access Control Context (Futuro)
  Responsável pela integração com catracas e controle de acesso.

  Inicialmente existirá apenas como interface para futuras integrações.

* ### Payment Context (Futuro)
  Responsável pelo gerenciamento de pagamentos e integração com gateways de pagamento.

  Inicialmente existirá apenas como interface para futuras integrações.

### 4.5 Comunicação entre Bounded Contexts

Os módulos devem permanecer o mais independentes possível.

Sempre que possível, a comunicação ocorrerá através de Eventos de Domínio.

Exemplo: 
```text
Enrollment
      │
      │ publica
      ▼
EnrollmentCreatedEvent
      │
      ├────────► Notification
      │
      └────────► Training
```

Outro exemplo:
```text
Pagamento recebido

↓

EnrollmentActivatedEvent

↓

Notification Module

↓

Envia e-mail de boas-vindas
```

Esse modelo reduz o acoplamento entre os módulos e facilita futuras integrações.

### 4.6 Eventos de Domínio

Os eventos representam acontecimentos relevantes do negócio.

Eles permitem que outros módulos reajam a essas mudanças sem depender diretamente do módulo de origem.

**Eventos previstos para o MVP**

  * **Matrículas**
    * EnrollmentCreated
    * EnrollmentActivated
    * EnrollmentCanceled
    * EnrollmentPlanChanged
    * EnrollmentBecameOverdue
  * **Treinos**
    * TrainingSheetCreated
    * TrainingSheetExpired
  * **Planos**
    * PlanCreated
    * PlanUpdated
    * PlanDeactivated
  * **Alunos**
    * StudentCreated
    * StudentUpdated
  * **Notificações**
    * NotificationSent
    * NotificationFailed
  
### 4.7 Fluxo de Eventos
Exemplo de alteração de plano:
```text
Recepcionista

↓

Alterar Plano

↓

Enrollment Module

↓

Cancela matrícula atual

↓

Cria nova matrícula

↓

Publica EnrollmentChangedPlanEvent

↓

Notification Module

↓

Envia notificação ao aluno
```

### 4.8 Notificações

O GymFlow utilizará um modelo orientado a eventos para envio de notificações.

O módulo de notificações será responsável apenas por transformar eventos de negócio em canais de comunicação.

Exemplos:
```text
| Evento                  | Ação                               |
| ----------------------- | ---------------------------------- |
| EnrollmentActivated     | E-mail de boas-vindas              |
| EnrollmentBecameOverdue | Aviso de inadimplência             |
| TrainingSheetExpired    | Solicitação de renovação do treino |
| PlanChanged             | Comunicação da alteração do plano  |
```

Nenhum módulo de negócio enviará e-mails, mensagens ou notificações diretamente.

Toda comunicação ocorrerá através do módulo de notificações.

### 4.9 Organização dos Módulos

Uma possível organização do projeto utilizando Spring Modulith:

```text
gymflow
│
├── student
│   ├── application
│   ├── domain
│   ├── infrastructure
│   └── api
│
├── enrollment
│   ├── application
│   ├── domain
│   ├── infrastructure
│   └── api
│
├── plan
│
├── training
│
├── notification
│
├── shared
│
└── config
```
Cada módulo será responsável apenas pelo próprio domínio, expondo funcionalidades por meio de interfaces bem definidas.

### 4.10 Decisões Arquiteturais

```text
| Decisão                 | Justificativa                                                                                                 |
| ----------------------- | ------------------------------------------------------------------------------------------------------------- |
| Monólito Modular        | Simplicidade de implantação, desenvolvimento e manutenção, com possibilidade de evolução para microsserviços. |
| Spring Modulith         | Garantir isolamento entre módulos e validação de dependências.                                                |
| Arquitetura Hexagonal   | Isolar regras de negócio da infraestrutura e facilitar testes.                                                |
| Domain-Driven Design    | Modelar o software de acordo com o domínio da academia.                                                       |
| Eventos de Domínio      | Reduzir acoplamento entre módulos e permitir extensibilidade.                                                 |
| UUID como identificador | Evitar dependência de identificadores sequenciais e facilitar integrações futuras.                            |
```


## 5. Modelo de Domínio

### 5.1 Visão Geral

O Modelo de Domínio representa os principais conceitos do negócio da academia e seus relacionamentos.

Seu objetivo é servir como referência para implementação das regras de negócio, definição dos casos de uso e organização dos módulos da aplicação.

As entidades apresentadas nesta seção não representam diretamente tabelas do banco de dados, mas sim conceitos do domínio.

### 5.2 Agregados do Domínio

O domínio do GymFlow será organizado em agregados (Aggregates), cada um responsável por manter a consistência de um conjunto de entidades relacionadas.

Os agregados definidos para o MVP são:

```text
| Agregado   | Raiz do Agregado | Responsabilidade                         |
| ---------- | ---------------- | ---------------------------------------- |
| Student    | Student          | Dados cadastrais do aluno                |
| Enrollment | Enrollment       | Vínculo entre aluno e plano              |
| Plan       | Plan             | Planos comercializados e seus benefícios |
| Training   | TrainingSheet    | Prescrição de treinos                    |
| Instructor  | Instructor        | Cadastro dos professores                 |

```

Cada agregado possui uma única Aggregate Root, responsável por garantir a integridade das regras de negócio.

### 5.3 Entidades do Domínio

* **Student**<br>
  Representa um aluno da academia, contendo informações pessoais e de contato.

  * **Responsabilidades:**
    * armazenar informações cadastrais;
    * indentificar unicamente um aluno;
    * servir como referência para matrículas e fichas de treino.

  * **Atributos:**
    ```text
    | Campo     | Descrição          |
    | --------- | ------------------ |
    | id        | UUID               |
    | fullName  | Nome completo      |
    | cpf       | CPF (único)        |
    | birthDate | Data de nascimento |
    | gender    | Sexo               |
    | email     | E-mail             |
    | phone     | Telefone           |
    | address   | Endereço           |
    | createdAt | Data de cadastro   |
    | updatedAt | Última atualização |
    ```
  
  * **Regras importantes:**
    * não possui status de ativo/inativo, permanecendo cadastrado mesmo após o cancelamento de matrículas;
    * não conhece planos;
    * não conhece pagamentos;
    * pode possuir múltiplas matrículas ao longo do tempo, mas apenas uma matrícula ativa por vez.
---
* **Enrollment**<br>
  Representa o vínculo comercial entre um aluno e a academia.

  É uma das entidades mais importantes do domínio.

  * **Responsabilidades:**
    * registrar a associação entre aluno e plano;
    * controlar o status da matrícula (ativa, pendente, cancelada, inadimplente);
    * servir como referência para notificações e bloqueio de acesso.
    * controlar o ciclo de vida da matrícula, incluindo datas de início e término.
    * representar mudanças de plano como novas matrículas, mantendo o histórico completo do aluno.
    * controlar inadimplência, bloqueando o acesso do aluno quando necessário.

  * **Atributos:**
    ```text
    | Campo       | Descrição                       |
    | ----------- | ------------------------------- |
    | id          | UUID                            |
    | studentId   | Referência ao Student           |
    | planId      | Referência ao Plan              |
    | status      | Situação da matrícula           |
    | startDate   | Data de início                  |
    | endDate     | Data de término (se aplicável)  |
    | dueDay      | Dia de vencimento               |
    | createdAt   | Data de criação                 |
    | updatedAt   | Última atualização              |
    ```

  * **Regras importantes:**
    * apenas uma matrícula ativa por aluno;
    * mudança de plano gera nova matrícula;
    * cancelamento encerra a matrícula;
    * inadimplência pertence à matrícula.
---
* **Plan**<br>
  Representa um plano de assinatura oferecido pela academia.

  * **Responsabilidades:**
    * armazenar informações sobre o plano;
    * controlar a disponibilidade do plano;
    * associar benefícios ao plano.
    * definir preço e condições de pagamento;

  * **Atributos:**
    ```text
    | Campo       | Descrição                                |
    | ----------- | -----------------------------------------|
    | id          | UUID                                     |
    | name        | Nome do plano                            |
    | description | Descrição do plano                       |
    | price       | Preço do plano                           |
    | isActive    | Disponibilidade do plano                 |
    | createdAt   | Data de criação                          |
    | updatedAt   | Última atualização                       |
    | benefits    | Lista de benefícios associados ao plano  |
    ```

  * **Regras importantes:**
    * planos podem ser ativados ou desativados;
    * planos desativados não podem ser utilizados para novas matrículas;
    * planos podem ter múltiplos benefícios associados.
---
* **Benefit**<br>
  Representa um benefício associado a um plano de assinatura.

  Exemplos:
    * Estacionamento
    * Avaliação Física
    * Armário
    * Área Premium
    * Aulas Coletivas
    * Piscina
    * Sauna

  * **Responsabilidades:**
    * armazenar informações sobre o benefício;
    * ser associado a planos.

  * **Atributos:**
    ```text
    | Campo       | Descrição                       |
    | ----------- | ------------------------------- |
    | id          | UUID                            |
    | name        | Nome do benefício               |
    | description | Descrição do benefício          |
    | isActive    | Disponibilidade do benefício   |
    | createdAt   | Data de criação                 |
    | updatedAt   | Última atualização              |
    ```

  * **Regras importantes:**
    * benefícios podem ser ativados ou desativados;
    * benefícios desativados não podem ser associados a novos planos.
---
* **Instructor**<br>
  Representa um professor da academia, responsável por prescrever treinos e acompanhar a evolução dos alunos.

  * **Responsabilidades:**
    * armazenar informações cadastrais do professor;
    * ser associado a fichas de treino;
    * registrar evolução dos alunos;
    * criar treinos e prescrever exercícios para os alunos;
    * atualizar treinos e registrar a evolução dos alunos;
    * acompanhar alunos.

  * **Atributos:**
    ```text
    | Campo     | Descrição          |
    | --------- | ------------------ |
    | id        | UUID               |
    | fullName  | Nome completo      |
    | cip       | Código de identificação do professor (único) |
    | email     | E-mail             |
    | phone     | Telefone           |
    | isActive  | Disponibilidade do professor |
    | createdAt | Data de cadastro   |
    | updatedAt | Última atualização |
    ```

  * **Regras importantes:**
    * cada professor possui um CIP único;
    * professores podem ser ativados ou desativados;
    * professores desativados não podem ser atribuídos a novas fichas de treino.
---
* **Exercise**<br>
  Representa um exercício físico que pode ser incluído em uma ficha de treino.

  * **Responsabilidades:**
    * armazenar informações sobre o exercício;
    * ser associado a fichas de treino.

  * **Atributos:**
    ```text
    | Campo       | Descrição                       |
    | ----------- | ------------------------------- |
    | id          | UUID                            |
    | name        | Nome do exercício               |
    | description | Descrição do exercício          |
    | isActive    | Disponibilidade do exercício   |
    | videoUrl    | URL do vídeo demonstrativo do exercício |
    | imageUrl    | URL da imagem do exercício     |
    | createdAt   | Data de criação                 |
    | updatedAt   | Última atualização              |
    ```
  >> **Importante:** Um exercício não possui informações como séries, repetições ou carga. Esses dados pertencem à prescrição do treino.

  * **Regras importantes:**
    * exercícios podem ser ativados ou desativados;
    * exercícios desativados não podem ser incluídos em novas fichas de treino.
---
* **TrainingSheet**<br>
  Representa a prescrição de treino de um aluno, contendo os exercícios, séries, repetições e carga sugerida.

  * **Responsabilidades:**
    * armazenar informações sobre a prescrição de treino;
    * ser associado a um aluno e a um professor;
    * registrar a evolução do aluno;
    * agrupar exercícios em uma ficha de treino, com detalhes como séries, repetições, carga e descanso;
    * controlar validade;
    * manter histórico de fichas de treino para cada aluno.

  * **Atributos:**
    ```text
    | Campo       | Descrição                       |
    | ----------- | ------------------------------- |
    | id          | UUID                            |
    | studentId   | Referência ao Student           |
    | instructorId| Referência ao Instructor        |
    | title       | Título da ficha de treino       |
    | exercises   | Lista de exercícios prescritos  |
    | startDate   | Data de início da prescrição    |
    | endDate     | Data de término da prescrição   |
    | expirationDate | Data de expiração da prescrição   |
    | isActive    | Indica se a ficha de treino está ativa |
    | createdAt   | Data de criação                 |
    | updatedAt   | Última atualização              |
    ```

  * **Regras importantes:**
    * cada aluno possui apenas uma ficha de treino ativa por vez;
    * fichas de treino possuem validade definida;
    * fichas expiradas não podem ser utilizadas para novos treinos.
---
* **TrainingSheetExercise**<br>
  Esta entidade representa a prescrição de um exercício dentro de uma ficha de treino.

  Ela faz a associação entre uma ficha e um exercício do catálogo.

  * **Responsabilidades:**
    * definir como o exercício será realizado dentro da ficha de treino;
    * armazenar parâmetros específicos de prescrição.

  * **Atributos:**
    ```text
    | Campo       | Descrição                       |
    | ----------- | ------------------------------- |
    | id          | UUID                            |
    | trainingSheetId | Referência à TrainingSheet   |
    | exerciseId  | Referência ao Exercise          |
    | order       | Ordem do exercício na ficha    |
    | sets        | Número de séries                |
    | repetitions | Número de repetições            |
    | load        | Carga sugerida                  |
    | restTime    | Tempo de descanso entre séries  |
    | observations| Observações adicionais          |
    ```

  * **Regras importantes:**
    * cada exercício em uma ficha de treino possui suas próprias prescrições;
    * alterações na prescrição de um exercício não afetam outras fichas de treino.
---

### 5.4 Relacionamentos

```text
Student
   │
   │ 1
   │
   └────────────── N Enrollment
                         │
                         │ N
                         │
                         ▼
                       Plan
                         │
                         │ N
                         │
                         ▼
                      Benefit


Professor
     │
     │1
     │
     └────────────── N TrainingSheet
                            │
                            │1
                            │
                            ▼
                    TrainingExercise
                            │
                            │N
                            │
                            ▼
                         Exercise
```

### 5.5 Value Objects

Nem tudo no domínio precisa ser uma entidade identificada por um UUID. Alguns conceitos existem apenas pelo seu valor e não possuem identidade própria.

Para o GymFlow, os principais Value Objects são:

```text
| Value Object | Descrição                                                                                   |
| ------------ | ------------------------------------------------------------------------------------------- |
| CPF          | Responsável por validar formato e dígitos verificadores.                                    |
| Email        | Garante formato válido e normalização.                                                      |
| Phone        | Representa um telefone no padrão adotado pela aplicação.                                    |
| Address      | Agrupa informações de endereço (logradouro, número, complemento, bairro, cidade, UF e CEP). |
| Money        | Representa valores monetários de forma segura, evitando problemas de precisão com `double`. |
```

Esses objetos encapsulam regras de validação e comportamento, reduzindo duplicação de código nas entidades.

### 5.6 Invariantes do Domínio

As seguintes regras devem ser garantidas pelo domínio, independentemente da interface utilizada:

  * Um aluno não pode possuir mais de uma matrícula ativa.
  * Uma matrícula deve estar vinculada a exatamente um aluno e um plano.
  * Um plano pode conter vários benefícios.
  * Um benefício pode ser compartilhado por vários planos.
  * Uma ficha de treino deve pertencer a um único aluno.
  * Uma ficha deve possuir exatamente um professor responsável.
  * Um exercício pode aparecer em diversas fichas de treino.
  * As informações de séries, repetições, carga e descanso pertencem à prescrição (TrainingExercise), e não ao exercício (Exercise).

## 6. Eventos de Domínio

### 6.1 Visão Geral

Os Eventos de Domínio representam acontecimentos relevantes dentro do negócio da academia.

Sempre que uma operação resultar em uma mudança significativa no estado do sistema, um evento poderá ser publicado para que outros módulos reajam de forma independente.

Essa abordagem reduz o acoplamento entre os módulos, melhora a manutenibilidade do sistema e facilita a evolução para integrações futuras.

Os eventos descritos nesta seção representam apenas acontecimentos do domínio, não detalhes técnicos de implementação.

### 6.2 Objetivos

A utilização de eventos de domínio possui os seguintes objetivos:

  * desacoplar os módulos do sistema;
  * permitir comunicação assíncrona entre contextos;
  * facilitar futuras integrações externas;
  * evitar dependências diretas entre regras de negócio;
  * tornar o domínio mais expressivo.

### 6.3 Fluxo Geral

Todo evento seguirá o mesmo ciclo de vida

```text
Caso de Uso

        │

        ▼

Regra de Negócio Executada

        │

        ▼

Estado do Domínio Alterado

        │

        ▼

Evento Publicado

        │

        ▼

Módulos Interessados Processam o Evento
```

Um módulo nunca deverá chamar diretamente outro módulo quando a comunicação puder ocorrer através de um evento.

### 6.4 Eventos do Contexto de Alunos

* **StudentRegisteredEvent**:
  * **Descrição:** Publicado quando um novo aluno é cadastrado.
  * **Origem**: Student Context
  * **Consumidores:** Notification Context
  * **Objetivo:** Permitir ações posteriores ao cadastro, como envio de mensagem de boas-vindas.
* **StudentUpdatedEvent**:
  * **Descrição:** Publicado quando os dados de um aluno são atualizados.
  * **Origem**: Student Context
  * **Consumidores:** Notification Context
  * **Objetivo:** Permitir ações posteriores à atualização, como envio de confirmação de alteração.

### 6.5 Eventos do Contexto de Matrículas

* **EnrollmentCreatedEvent**:
  * **Descrição:** Publicado quando uma nova matrícula é criada.
  * **Origem**: Enrollment Context
  * **Consumidores:** Notification Context
  * **Objetivo:** Notificar sobre a criação da matrícula e permitir ações relacionadas à prescrição de treinos.
  * **Possíveis Ações:** Enviar confirmação de matrícula, registrar auditoria, iniciar processos futuros.
* **EnrollmentActivatedEvent**:
  * **Descrição:** Publicado quando o pagamento inicial é confirmado.
  * **Origem**: Enrollment Context
  * **Consumidores:** Notification Context, Access Control Context (futuro)
  * **Objetivo:** Notificar sobre a ativação da matrícula e permitir ações relacionadas à prescrição de treinos.
  * **Possíveis Ações:** Enviar boas-vindas, liberar acesso a recursos, iniciar acompanhamento de treinos.
* **EnrollmentCanceledEvent**:
  * **Descrição:** Publicado quando uma matrícula é cancelada.
  * **Origem**: Enrollment Context
  * **Consumidores:** Notification Context, Access Control Context (futuro)
  * **Objetivo:** Notificar sobre o cancelamento da matrícula e permitir ações relacionadas à prescrição de treinos.
  * **Possíveis Ações:** Enviar confirmação de cancelamento, revogar acesso a recursos, atualizar histórico do aluno.
* **EnrollmentPlanChangedEvent**:
  * **Descrição:** Publicado quando um aluno altera seu plano.
  * **Origem**: Enrollment Context
  * **Consumidores:** Notification Context, Access Control Context (futuro)
  * **Objetivo:** Notificar sobre a alteração do plano e permitir ações relacionadas à prescrição de treinos.
  * **Possíveis Ações:** Enviar confirmação de alteração, atualizar benefícios e recursos disponíveis, ajustar acompanhamento de treinos.
* **EnrollmentBecameOverdueEvent**:
  * **Descrição:** Publicado quando uma matrícula se torna inadimplente.
  * **Origem**: Enrollment Context
  * **Consumidores:** Notification Context, Access Control Context (futuro)
  * **Objetivo:** Notificar sobre a inadimplência e permitir ações relacionadas à prescrição de treinos.
  * **Possíveis Ações:** Enviar aviso de inadimplência, bloquear acesso a recursos, iniciar processo de cobrança (futuro).

### 6.6 Eventos do Contexto de Planos

* **PlanCreatedEvent**:
  * **Descrição:** Publicado quando um novo plano é criado.
  * **Origem**: Plan Context
  * **Consumidores:** Notification Context
  * **Objetivo:** Notificar sobre a criação do plano e permitir ações relacionadas à prescrição de treinos.
  * **Possíveis Ações:** Enviar confirmação de criação, atualizar catálogo de planos disponíveis, iniciar campanhas de marketing (futuro).
* **PlanUpdatedEvent**:
  * **Descrição:** Publicado quando um plano existente é atualizado.
  * **Origem**: Plan Context
  * **Consumidores:** Notification Context
  * **Objetivo:** Notificar sobre a atualização do plano e permitir ações relacionadas à prescrição de treinos.
  * **Possíveis Ações:** Enviar confirmação de atualização, ajustar benefícios e recursos disponíveis, atualizar documentação do plano.
* **PlanDeactivatedEvent**:
  * **Descrição:** Publicado quando um plano é desativado.
  * **Origem**: Plan Context
  * **Consumidores:** Notification Context
  * **Objetivo:** Notificar sobre a desativação do plano e permitir ações relacionadas à prescrição de treinos.
  * **Possíveis Ações:** Enviar aviso de desativação, atualizar catálogo de planos disponíveis, ajustar matrículas existentes (futuro).

### 6.7 Eventos do Contexto de Professores

* **InstructorCreatedEvent**:
  * **Descrição:** Publicado quando um novo professor é cadastrado.
  * **Origem**: Instructor Context
  * **Consumidores:** Notification Context
  * **Objetivo:** Notificar sobre o cadastro do professor e permitir ações relacionadas à prescrição de treinos.
  * **Possíveis Ações:** Enviar confirmação de cadastro, atualizar lista de professores disponíveis, iniciar integração com sistemas internos (futuro).
* **InstructorUpdatedEvent**:
  * **Descrição:** Publicado quando os dados de um professor são atualizados.
  * **Origem**: Instructor Context
  * **Consumidores:** Notification Context
  * **Objetivo:** Notificar sobre a atualização do professor e permitir ações relacionadas à prescrição de treinos.
  * **Possíveis Ações:** Enviar confirmação de atualização, ajustar informações de contato, atualizar registros internos (futuro).
* **InstructorDeactivatedEvent**:
  * **Descrição:** Publicado quando um professor é desativado.
  * **Origem**: Instructor Context
  * **Consumidores:** Notification Context
  * **Objetivo:** Notificar sobre a desativação do professor e permitir ações relacionadas à prescrição de treinos.
  * **Possíveis Ações:** Enviar aviso de desativação, atualizar lista de professores disponíveis, ajustar atribuições de treinos (futuro).

### 6.8 Eventos do Contexto de Treinos

* **TrainingSheetCreatedEvent**:
  * **Descrição:** Publicado quando uma nova ficha de treino é criada.
  * **Origem**: Training Context
  * **Consumidores:** Notification Context
  * **Objetivo:** Notificar sobre a criação da ficha de treino e permitir ações relacionadas à prescrição de treinos.
  * **Possíveis Ações:** Enviar confirmação de criação, atualizar histórico de treinos do aluno, iniciar acompanhamento de evolução (futuro).
* **TrainingSheetExpiredEvent**:
  * **Descrição:** Publicado quando uma ficha de treino expira.
  * **Origem**: Training Context
  * **Consumidores:** Notification Context
  * **Objetivo:** Notificar sobre a expiração da ficha de treino e permitir ações relacionadas à prescrição de treinos.
  * **Possíveis Ações:** Enviar aviso de expiração, solicitar renovação da ficha de treino, atualizar status da ficha (futuro).
* **TrainingSheetUpdatedEvent**:
  * **Descrição:** Publicado quando uma ficha de treino é atualizada.
  * **Origem**: Training Context
  * **Consumidores:** Notification Context
  * **Objetivo:** Notificar sobre a atualização da ficha de treino e permitir ações relacionadas à prescrição de treinos.
  * **Possíveis Ações:** Enviar confirmação de atualização, atualizar histórico de treinos do aluno, ajustar acompanhamento de evolução (futuro).

### 6.9 Eventos Futuros
Os eventos abaixo não fazem parte do MVP, mas já são previstos pela arquitetura.

* PaymentApprovedEvent
  * Pagamento aprovado.
* PaymentFailedEvent
  * Pagamento falhou.
* PhysicalAssessmentCompletedEvent
  * Avaliação física concluída.
* AccessGrantedEvent
  * Acesso liberado.
* AccessDeniedEvent
  * Acesso negado.
* ClassScheduledEvent
  * Aula agendada.


### 6.10 Comunicação entre Contextos

O diagrama abaixo apresenta uma visão simplificada da comunicação entre os principais módulos do GymFlow.

```text
                         Student
                            │
        StudentRegisteredEvent
                            │
                            ▼
                     Notification


                       Enrollment
                            │
        ┌───────────────────┼───────────────────┐
        ▼                   ▼                   ▼
EnrollmentActivated   EnrollmentChanged   EnrollmentCancelled
        │                   │                   │
        ▼                   ▼                   ▼
 Notification        Notification      Access Control


                     Training
                          │
      ┌───────────────────┴──────────────────┐
      ▼                                      ▼
TrainingSheetCreated             TrainingSheetExpired
      │                                      │
      ▼                                      ▼
 Notification                     Notification
 ```

### 6.11 Diretrizes para Criação de Eventos

Para manter consistência entre os módulos, todo novo evento deverá seguir as seguintes diretrizes:

* **Deve representar um fato do negócio**
  * ✔  Matrícula ativada.
  * ❌ Usuário clicou em um botão.
---
* **Deve utilizar verbo no passado**
  * ✔  EnrollmentActivated
  * ❌ ActivateEnrollment
---
* **Deve ser imutável**
  * Após publicado, um evento nunca deverá ser alterado.
---
* **Deve conter apenas informações necessárias**
  * Os eventos não devem transportar objetos completos do domínio.

  Exemplo:
  ```java
  public record EnrollmentActivatedEvent(
    UUID enrollmentId,
    UUID studentId,
    UUID planId
  ) {}
  ```
  Evite: 

  ```java
  public record EnrollmentActivatedEvent(
    Enrollment enrollment,
    Student student,
    Plan plan
  ) {}
  ```

  Isso reduz o acoplamento entre módulos.
---
* **Não deve depender de infraestrutura**
  * Eventos pertecem ao domínio e não devem ter dependências de frameworks, bibliotecas ou tecnologias específicas.
  * Eles não conhecem:
    * Kafka;
    * RabbitMQ;
    * REST;
    * Banco de Dados;
    * Spring Events.
  * A tecnologia utilizada para transporte do evento é responsabilidade do módulo de infraestrutura.

### 6.11 Implementação no GymFlow

O GymFlow será desenvolvido como um Monólito Modular, porém a comunicação entre os módulos ocorrerá por meio de eventos publicados no Apache Kafka.

Embora todos os módulos façam parte da mesma aplicação, eles não deverão depender diretamente uns dos outros. Sempre que uma regra de negócio resultar em uma mudança relevante no domínio, o módulo responsável publicará um evento em um tópico do Kafka.

Os módulos interessados poderão consumir esse evento e executar suas próprias regras de negócio de forma independente.

Essa abordagem proporciona:
  * baixo acoplamento entre os módulos;
  * maior isolamento das responsabilidades;
  * facilidade para adicionar novas funcionalidades sem alterar módulos existentes;
  * possibilidade de evolução para uma arquitetura distribuída no futuro;
  * experiência prática com arquitetura orientada a eventos utilizando Apache Kafka.

**Fluxo de Comunicação**<br>
A comunicação entre os módulos seguirá o fluxo abaixo.
```text
                 Caso de Uso
                      │
                      ▼
            Regra de Negócio Executada
                      │
                      ▼
             Estado do Domínio Alterado
                      │
                      ▼
             Publicação no Apache Kafka
                      │
        ┌─────────────┼─────────────┐
        ▼             ▼             ▼
 Notification     Training      Access Control
     Module         Module          Module

```
Nenhum módulo deverá invocar diretamente serviços pertencentes a outro contexto quando a comunicação puder ocorrer através de eventos.

**Organização dos Tópicos**<br>
Cada contexto de negócio será responsável por publicar eventos em tópicos específicos.

```text
| Contexto     | Tópico Kafka                     |
| ------------ | -------------------------------- |
| Student      | `student.events`                 |
| Enrollment   | `enrollment.events`              |
| Plan         | `plan.events`                    |
| Training     | `training.events`                |
| Notification | `notification.events` (opcional) |
```

Cada tópico poderá conter diferentes tipos de eventos relacionados ao seu contexto.

Exemplo para o contexto de Matrículas:
```text
Topic: enrollment.events

├── EnrollmentCreatedEvent
├── EnrollmentActivatedEvent
├── EnrollmentCancelledEvent
├── EnrollmentChangedPlanEvent
└── EnrollmentBecameOverdueEvent
```

**Publicação de Eventos**<br>
Após a conclusão de uma regra de negócio, o módulo responsável deverá publicar um evento descrevendo a alteração ocorrida.

Exemplo:
```text
Recepcionista

        │

        ▼

Alterar Plano

        │

        ▼

Enrollment Context

        │

        ▼

Cancela Matrícula Atual

        │

        ▼

Cria Nova Matrícula

        │

        ▼

Publica
EnrollmentChangedPlanEvent

        │

        ▼

Kafka Topic
(enrollment.events)

        │

        ├────────► Notification Context
        │
        ├────────► Access Control Context
        │
        └────────► Futuras Integrações
```

**Consumo de Eventos**<br>
Cada módulo será responsável por consumir apenas os eventos necessários para executar suas próprias responsabilidades.

Por exemplo:
```text
| Evento                       | Consumidores                                 |
| ---------------------------- | -------------------------------------------- |
| EnrollmentActivatedEvent     | Notification Context, Access Control Context |
| EnrollmentChangedPlanEvent   | Notification Context                         |
| EnrollmentBecameOverdueEvent | Notification Context, Access Control Context |
| TrainingSheetExpiredEvent    | Notification Context                         |
```
Essa abordagem garante que cada contexto permaneça responsável apenas pelo seu próprio domínio.

**Independência do Domínio**<br>

Apesar de os eventos serem transportados pelo Apache Kafka, o Domínio não conhecerá essa tecnologia.

As regras de negócio apenas indicarão que determinado evento deve ser publicado.

A responsabilidade de serializar, publicar e consumir mensagens será da camada de infraestrutura, preservando os princípios da Arquitetura Hexagonal e do Domain-Driven Design.

Essa separação permite substituir o mecanismo de mensageria no futuro sem alterar as regras de negócio.

**Considerações Arquiteturais**<br>
A adoção do Apache Kafka em um Monólito Modular não tem como objetivo melhorar a comunicação entre processos distintos, mas sim promover um modelo arquitetural orientado a eventos desde o início do projeto.

Essa decisão traz benefícios como: 
  * desacoplamento entre módulos;
  * comunicação assíncrona;
  * facilidade para inclusão de novos consumidores;
  * preparação para futuras integrações externas;
  * possibilidade de evolução para microsserviços sem alterar o modelo de eventos do domínio.

## 7. Notificações

### 7.1 Visão Geral

O módulo de Notificações é responsável por informar alunos e colaboradores sobre acontecimentos relevantes do sistema.

As notificações não fazem parte das regras de negócio dos demais módulos. Em vez disso, elas são disparadas a partir de eventos publicados pelos contextos de negócio e processadas de forma assíncrona.

Essa abordagem garante que funcionalidades como envio de e-mails, mensagens ou notificações push permaneçam desacopladas das regras de negócio da aplicação.

### 7.2 Objetivos

O módulo de Notificações possui os seguintes objetivos:

  * centralizar toda comunicação com os usuários;
  * desacoplar notificações das regras de negócio;
  * permitir diferentes canais de comunicação;
  * facilitar inclusão de novos meios de envio;
  * possibilitar processamento assíncrono através do Apache Kafka.

### 7.3 Arquitetura

O módulo de Notificações não será invocado diretamente pelos demais módulos.

Toda comunicação ocorrerá através de eventos publicados no Apache Kafka.

```text
                Enrollment Context
                        │
                        ▼
          EnrollmentActivatedEvent
                        │
                        ▼
                Apache Kafka
                        │
                        ▼
            Notification Context
                        │
         ┌──────────────┼──────────────┐
         ▼              ▼              ▼
      E-mail        WhatsApp      Push Notification
```

Essa arquitetura permite adicionar novos canais de comunicação sem modificar os módulos de origem.

### 7.4 Fluxo de Funcionamento

O envio de notificações seguirá o fluxo abaixo.

```text
Regra de Negócio

        │

        ▼

Evento Publicado

        │

        ▼

Apache Kafka

        │

        ▼

Notification Context

        │

        ▼

Seleciona Template

        │

        ▼

Seleciona Canal

        │

        ▼

Envia Notificação
```

Nenhum módulo deverá possuir lógica para envio direto de mensagens.


### 7.5 Eventos Consumidos

O módulo de Notificações consumirá eventos publicados por diferentes contextos.

```text
| Evento                       | Origem     | Ação                        |
| ---------------------------- | ---------- | --------------------------- |
| StudentRegisteredEvent       | Student    | Mensagem de boas-vindas     |
| EnrollmentCreatedEvent       | Enrollment | Confirmação da matrícula    |
| EnrollmentActivatedEvent     | Enrollment | Matrícula ativada           |
| EnrollmentChangedPlanEvent   | Enrollment | Alteração de plano          |
| EnrollmentCancelledEvent     | Enrollment | Confirmação do cancelamento |
| EnrollmentBecameOverdueEvent | Enrollment | Aviso de inadimplência      |
| TrainingSheetCreatedEvent    | Training   | Nova ficha disponível       |
| TrainingSheetExpiredEvent    | Training   | Solicitação de renovação    |

```

### 7.6 Canais de Comunicação

O módulo deverá permitir múltiplos canais de comunicação.

* **E-mail:**
  * Utilizado para comunicações formais
  Exemplos:
    * matrícula criada;
    * alteração de plano;
    * cancelamento;
    * comprovantes;
    * recuperação de senha.

* **WhatsApp:**
  * Utilizado para comunicações rápidas e informais
  Exemplos:
    * aviso de inadimplência;
    * lembrete de renovação de ficha de treino;
    * mensagens promocionais.
  A integração será realizada futuramente através da API oficial do WhatsApp Business.

* **Push Notification:**
  * Utilizado para comunicações instantâneas
  Exemplos:
    * aviso de expiração de ficha de treino;
    * lembrete de aula agendada;
    * notificações de eventos especiais.
  A integração será realizada futuramente através de serviços como Firebase Cloud Messaging (FCM) ou Apple Push Notification Service (APNS).

### 7.7 Templates de Notificação

Cada tipo de evento poderá possuir um template específico.

Exemplo:
```text
| Evento                    | Template                  |
| ------------------------- | ------------------------- |
| EnrollmentActivatedEvent  | enrollment-activated.html |
| EnrollmentCancelledEvent  | enrollment-cancelled.html |
| TrainingSheetExpiredEvent | training-expired.html     |
```

Essa separação facilita manutenção, personalização e internacionalização.

### 7.8 Falhas no Envio

O envio de notificações não deverá impedir a execução da regra de negócio que originou o evento.

Caso ocorra falha durante o processamento:
  * a operação principal deverá permanecer concluída;
  * o erro deverá ser registrado em log;
  * a mensagem poderá ser reenviada posteriormente conforme a política de retentativas.

### 7.9 Extensibilidade
Novos canais de comunicação poderão ser adicionados sem necessidade de alterar os módulos de negócio.

Exemplos de futuras integrações:
  * SMS;
  * Microsoft Teams;
  * Slack;
  * Telegram;
  * Discord;
  * Webhooks para sistemas parceiros.

### 7.10 Responsabilidades do Módulo

O Notification Context é responsável por:
  * consumir eventos publicados no Apache Kafka;
  * identificar o tipo de evento recebido;
  * selecionar o template correspondente;
  * definir o canal de comunicação;
  * realizar o envio da mensagem;
  * registrar o resultado do processamento.

O módulo não é responsável por:
  * validar regras de negócio;
  * decidir quando um evento deve ser publicado;
  * alterar dados de outros contextos.

Essas responsabilidades pertencem aos módulos de origem.

### 7.11 Decisões Arquiteturais

```text
| Decisão                        | Justificativa                                               |
| ------------------------------ | ----------------------------------------------------------- |
| Comunicação baseada em eventos | Reduz o acoplamento entre módulos.                          |
| Consumo via Apache Kafka       | Permite processamento assíncrono e futura escalabilidade.   |
| Templates separados da lógica  | Facilita manutenção e personalização das mensagens.         |
| Múltiplos canais               | Possibilita evolução da comunicação sem impacto no domínio. |
| Processamento independente     | Falhas de envio não comprometem as regras de negócio.       |
```

###

## 8. APIs REST

### 8.1 Visão Geral

O GymFlow disponibilizará uma API REST para acesso às funcionalidades do sistema. A API seguirá os princípios REST, utilizando recursos, verbos HTTP e códigos de resposta padronizados. As URLs representarão recursos do domínio, evitando ações explícitas sempre que possível.

### 8.2 Convenções Gerais

**Versionamento**

Todas as APIs serão versionadas.

```text
/api/v1
```

Exemplo:
```text
GET /api/v1/students
```
---
**Formato**

Todas as requisições e respostas utilizarão o formato JSON.

```text
Context-Type: application/json
```
---
**Identificadores**
Todos os recursos serão identificados por UUID.
```text
GET /api/v1/students/{studentId}
```
---
**Páginação**
Endpoints de listagem deverão suportar paginação.
```text
GET /api/v1/students?page=1&size=20
```
---
**Ordenação**
Endpoints de listagem deverão permitir ordenação por campos específicos.
```text
GET /students?sort=fullName,asc
```
---
**Filtros**
Filtros serão realizados através de query parameters.
```text
GET /students?isActive=true

GET /enrollments?planId=123e4567-e89b-12d3-a456-426614174000&status=active

GET /plans?isActive=true&benefitId=123e4567-e89b-12d3-a456-426614174000
```

Observe que evitamos criar endpoints específicos para cada situação.

### 8.3 Students API

**Criar um novo aluno**
```http
POST /api/v1/students
```
**Listar alunos**
```http
GET /api/v1/students
```
Filtros disponíveis:
```http
GET /api/v1/students?name=Maria

GET /api/v1/students?cpf=12345678900

GET /api/v1/students?email=...

GET /api/v1/students?isActive=true

GET /api/v1/students?isActive=false
```
**Atualizar dados de um aluno**
```http
PUT /api/v1/students/{studentId}
```

### 8.4 Enrollments API

**Criar uma nova matrícula**
```http
POST /api/v1/enrollments
```
**Listar matrículas**
```http
GET /api/v1/enrollments
```
Filtros disponíveis:
```http
GET /api/v1/enrollments?status=ACTIVE

GET /api/v1/enrollments?studentId=...

GET /api/v1/enrollments?planId=...

GET /api/v1/enrollments?overdue=true
```
**Buscar matrícula por ID**
```http
GET /api/v1/enrollments/{enrollmentId}
```
**Cancelar Matrícula**
```http
PATCH /api/v1/enrollments/{enrollmentId}/cancel
```
**Alterar Plano da Matrícula**
```http
POST /api/v1/enrollments/{enrollmentId}/change-plan
```

### 8.5 Plans API

**Criar Plano**
```http
POST /api/v1/plans
```
**Listar Planos**
```http
GET /api/v1/plans
```
Filtros disponíveis:
```http
GET /api/v1/plans?isActive=true
GET /api/v1/plans?isActive=false
GET /api/v1/plans?name=...
```
**Atualizar Plano**
```http
PUT /api/v1/plans/{planId}
```
**Desativar Plano**
```http
PATCH /api/v1/plans/{planId}/deactivate
```

### 8.6 Benefits API
**Criar Benefício**
```http
POST /api/v1/benefits
```
**Listar Benefícios**
```http
GET /api/v1/benefits
```
Filtros disponíveis:
```http
GET /api/v1/benefits?isActive=true
GET /api/v1/benefits?isActive=false
GET /api/v1/benefits?name=...
```
**Atualizar Benefício**
```http
PUT /api/v1/benefits/{benefitId}
```
**Desativar Benefício**
```http
PATCH /api/v1/benefits/{benefitId}/deactivate
```

### 8.7 Trainings API
**Criar Ficha de Treino**
```http
POST /api/v1/training-sheets
```
**Listar Fichas de Treino**
```http
GET /api/v1/training-sheets
```
Filtros disponíveis:
```http
GET /api/v1/training-sheets?studentId=...

GET /api/v1/training-sheets?professorId=...

GET /api/v1/training-sheets?status=ACTIVE
```
**Buscar Ficha de Treino por ID**
```http
GET /api/v1/training-sheets/{trainingSheetId}
```
**Atualizar Ficha de Treino**
```http
PUT /api/v1/training-sheets/{trainingSheetId}
```
**Encerrar Ficha de Treino**
```http
PATCH /api/v1/training-sheets/{trainingSheetId}/finish
```

### 8.9 Professors API
**Criar Professor**
```http
POST /api/v1/instructors
```
**Listar Professores**
```http
GET /api/v1/instructors
```
Filtros disponíveis:
```http
GET /api/v1/instructors?isActive=true
GET /api/v1/instructors?isActive=false
GET /api/v1/instructors?name=...
```
**Buscar Professor por ID**
```http
GET /api/v1/instructors/{instructorId}
```
**Atualizar Professor**
```http
PUT /api/v1/instructors/{instructorId}
```
**Desativar Professor**
```http
PATCH /api/v1/instructors/{instructorId}/deactivate
```

### 8.10 Códigos HTTP
```text
| Código                    | Significado                                                                   |
| ------------------------- | ----------------------------------------------------------------------------- |
| 200 OK                    | Operação realizada com sucesso.                                               |
| 201 Created               | Recurso criado com sucesso.                                                   |
| 204 No Content            | Operação concluída sem conteúdo na resposta.                                  |
| 400 Bad Request           | Dados inválidos na requisição.                                                |
| 401 Unauthorized          | Usuário não autenticado.                                                      |
| 403 Forbidden             | Usuário autenticado, mas sem permissão.                                       |
| 404 Not Found             | Recurso não encontrado.                                                       |
| 409 Conflict              | Violação de regra de negócio (ex.: CPF duplicado ou segunda matrícula ativa). |
| 422 Unprocessable Entity  | Dados válidos sintaticamente, mas inconsistentes com regras de domínio.       |
| 500 Internal Server Error | Erro inesperado no servidor.                                                  |

```

### 8.10 Princípios adotados

A API REST do GymFlow seguirá os seguintes princípios:
  * URLs representam recursos, e não ações, sempre que possível.
  * Verbos HTTP expressam a intenção da operação.
  * Filtros são realizados por query parameters.
  * Recursos não são removidos fisicamente quando isso viola regras do domínio.
  * Operações que representam processos de negócio podem utilizar sub-recursos (/cancel, /deactivate, /change-plan) quando não se enquadram em um CRUD tradicional.
  * A API deve refletir o modelo de domínio e não a estrutura do banco de dados.

## 9. Modelo de Dados

### 9.1 Visão Geral

O Modelo de Dados descreve como as informações do domínio do GymFlow serão persistidas.

Embora inspirado no Modelo de Domínio, este capítulo apresenta as entidades sob a perspectiva da persistência, definindo seus atributos, relacionamentos e restrições.

O objetivo é fornecer uma visão clara da estrutura do banco de dados, servindo como referência para implementação das entidades JPA, migrações do Flyway e consultas ao banco de dados.

O GymFlow utilizará o PostgreSQL como sistema gerenciador de banco de dados.

---

### 9.2 Convenções de Modelagem

As seguintes convenções serão adotadas em todas as tabelas do sistema.

**Identificadores**
Todas as entidades utilizarão UUID como chave primária.

Exemplo:
  * id UUID PRIMARY KEY

---

**Auditoria**
Todas as tabelas possuirão os seguintes campos:

| Campo      | Descrição          |
| ---------- | ------------------ |
| created_at | Data de criação    |
| updated_at | Última atualização |

Quando necessário, poderão existir campos adicionais como:
  * deactivated_at
  * cancelled_at
  * expires_at

---

**Chaves Estrangeiras**
Os relacionamentos utilizarão chaves estrangeiras para garantir integridade referencial.

Exemplo:
  * student_id
  * plan_id
  * professor_id

---
**Exclusão**

O GymFlow não realizará exclusão física de informações que façam parte do histórico do negócio.

Sempre que possível será utilizado o conceito de encerramento ou desativação do registro.

---

### 9.3 Entidades

**Student**
Representa o cadastro permanente de um aluno.
  * **Campos**

  | Campo      | Tipo                         | Obrigatório |
  | ---------- | ---------------------------- | ----------- |
  | id         | UUID                         | Sim         |
  | full_name  | VARCHAR                      | Sim         |
  | cpf        | VARCHAR(11)                  | Sim (Único) |
  | birth_date | DATE                         | Sim         |
  | gender     | VARCHAR                      | Sim         |
  | email      | VARCHAR                      | Sim         |
  | phone      | VARCHAR                      | Sim         |
  | address    | JSONB ou campos normalizados | Sim         |
  | created_at | TIMESTAMP                    | Sim         |
  | updated_at | TIMESTAMP                    | Sim         |

  * **Restrições**
    * CPF deve ser único.
    * O aluno nunca será removido fisicamente.

---

**Plan**

Representa um plano comercializado pela academia.

  * **Campos**

| Campo         | Tipo      |
| ------------- | --------- |
| id            | UUID      |
| name          | VARCHAR   |
| description   | TEXT      |
| periodicity   | ENUM      |
| price         | DECIMAL   |
| active        | BOOLEAN   |
| created_at    | TIMESTAMP |
| updated_at    | TIMESTAMP |

---

**Benefit**

Representa um benefício que pode ser associado a diferentes planos.

  * **Campos**

| Campo       | Tipo      |
| ----------- | --------- |
| id          | UUID      |
| name        | VARCHAR   |
| description | TEXT      |
| active      | BOOLEAN   |
| created_at  | TIMESTAMP |
| updated_at  | TIMESTAMP |

---

**Plan_Benefit**

Tabela responsável pela associação entre planos e benefícios.

  * **Campos**

| Campo      | Tipo |
| ---------- | ---- |
| plan_id    | UUID |
| benefit_id | UUID |

  * **Observações**
    * Um plano pode possuir vários benefícios.
    * Um benefício pode pertencer a vários planos.

---

**Enrollment**

Representa o vínculo entre um aluno e um plano.

  * **Campos**

| Campo      | Tipo      |
| ---------- | --------- |
| id         | UUID      |
| student_id | UUID      |
| plan_id    | UUID      |
| status     | VARCHAR   |
| start_date | DATE      |
| end_date   | DATE      |
| due_day    | SMALLINT  |
| created_at | TIMESTAMP |
| updated_at | TIMESTAMP |

  * **Restrições**
    * Apenas uma matrícula ativa por aluno.
    * Mudança de plano gera uma nova matrícula.

---

**Professor**

Representa um professor da academia.

  * **Campos**

| Campo      | Tipo      |
| ---------- | --------- |
| id         | UUID      |
| full_name  | VARCHAR   |
| cip        | VARCHAR   |
| email      | VARCHAR   |
| phone      | VARCHAR   |
| specialty  | VARCHAR   |
| active     | BOOLEAN   |
| created_at | TIMESTAMP |
| updated_at | TIMESTAMP |

---

**Exercise**

Catálogo de exercícios.

  * **Campos**

| Campo                 | Tipo      |
| --------------------- | --------- |
| id                    | UUID      |
| name                  | VARCHAR   |
| muscle_group          | VARCHAR   |
| execution_description | TEXT      |
| video_url             | VARCHAR   |
| created_at            | TIMESTAMP |
| updated_at            | TIMESTAMP |

  * **Observações**
    * Não armazena séries, repetições ou carga.

---

**Training_Sheet**

Representa uma ficha de treino.

  * **Campos**

| Campo           | Tipo      |
| --------------- | --------- |
| id              | UUID      |
| student_id      | UUID      |
| professor_id    | UUID      |
| title           | VARCHAR   |
| start_date      | DATE      |
| expiration_date | DATE      |
| status          | VARCHAR   |
| created_at      | TIMESTAMP |
| updated_at      | TIMESTAMP |

---

**Training_Exercise**

Representa um exercício prescrito dentro de uma ficha.

  * **Campos**

| Campo             | Tipo    |
| ----------------- | ------- |
| id                | UUID    |
| training_sheet_id | UUID    |
| exercise_id       | UUID    |
| execution_order   | INTEGER |
| sets              | INTEGER |
| repetitions       | VARCHAR |
| load              | VARCHAR |
| rest_time         | INTEGER |
| observations      | TEXT    |

  * **Observações**
    * Um mesmo exercício poderá aparecer em diversas fichas, com parâmetros diferentes

.

---

### 9.4 Relacionamentos

| Origem        | Destino          | Cardinalidade |
| ------------- | ---------------- | ------------- |
| Student       | Enrollment       | 1:N           |
| Plan          | Enrollment       | 1:N           |
| Plan          | Benefit          | N:N           |
| Professor     | TrainingSheet    | 1:N           |
| Student       | TrainingSheet    | 1:N           |
| TrainingSheet | TrainingExercise | 1:N           |
| Exercise      | TrainingExercise | 1:N           |

---

### 9.5 Restrições de Integridade

O banco de dados deverá garantir as seguintes restrições:
  * CPF único para cada aluno.
  * Integridade referencial entre todas as entidades.
  * Não permitir matrículas sem aluno.
  * Não permitir matrículas sem plano.
  * Não permitir fichas sem professor responsável.
  * Não permitir exercícios prescritos sem ficha de treino.
  * Não permitir benefícios associados a planos inexistentes.

As regras de negócio mais complexas continuarão sendo validadas pela camada de domínio.

---

### 9.6 Estratégia de Persistência

A persistência do GymFlow seguirá as seguintes diretrizes:
  * PostgreSQL como banco de dados relacional.
  * Flyway para versionamento do esquema.
  * Spring Data JPA como mecanismo de persistência.
  * UUID como chave primária.
  * Índices criados para consultas frequentes.
  * Constraints para garantir integridade referencial.

---

### 9.7 Índices Recomendados

Os seguintes índices deverão ser criados para otimizar consultas frequentes:

| Tabela         | Índice       |
| -------------- | ------------ |
| student        | cpf (único)  |
| student        | full_name    |
| enrollment     | student_id   |
| enrollment     | status       |
| enrollment     | plan_id      |
| training_sheet | student_id   |
| training_sheet | professor_id |
| exercise       | muscle_group |

A definição exata dos índices poderá ser refinada conforme o crescimento da aplicação e a análise de desempenho em ambiente de produção.


## 10. Roadmap

