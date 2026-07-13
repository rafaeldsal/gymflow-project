# GymFlow - Documentação Oficial v2.0

- [1. Visão do Produto](#1-visão-do-produto)
  - [1.1. Objetivo do GymFlow](#11-objetivo-do-gymflow)
  - [1.2. Público-Alvo](#12-público-alvo)
  - [1.3. Escopo do MVP](#13-escopo-do-mvp)
  - [1.4. Fora do Escopo do MVP](#14-fora-do-escopo-do-mvp)
- [2. Regras de Negócio](#2-regras-de-negócio)
  - [2.1. Academia (Tenant)](#21-academia-tenant)
  - [2.2. Unidade](#22-unidade)
  - [2.3. Controle de Acesso](#23-controle-de-acesso)
  - [2.4. Alunos](#24-alunos)
  - [2.5. Matrículas](#25-matrículas)
  - [2.6. Planos e Benefícios](#26-planos-e-benefícios)
  - [2.7. Professores](#27-professores)
  - [2.8. Treinos](#28-treinos)
  - [2.9. Notificações](#29-notificações)
- [3. Casos de Uso](#3-casos-de-uso)
  - [3.1. Academia](#31-academia)
  - [3.2. Unidade](#32-unidade)
  - [3.3. Controle de Acesso](#33-controle-de-acesso)
  - [3.4. Aluno](#34-aluno)
  - [3.5. Matrícula](#35-matrícula)
  - [3.6. Planos](#36-planos)
  - [3.7. Benefícios](#37-benefícios)
  - [3.8. Professores](#38-professores)
  - [3.9. Ficha de Treinos](#39-ficha-de-treinos)
- [4. Arquitetura do Sistema](#4-arquitetura-do-sistema)
  - [4.1. Visão Geral](#41-visão-geral)
  - [4.2. Princípios Arquiteturais](#42-princípios-arquiteturais)
  - [4.3. Camadas do Sistema](#43-camadas-do-sistema)
  - [4.4. Bounded Contexts](#44-bounded-contexts)
  - [4.5. Comunicação entre Bounded Contexts](#45-comunicação-entre-bounded-contexts)
  - [4.6. Eventos de Domínio](#46-eventos-de-domínio)
  - [4.7. Fluxo de Eventos](#47-fluxo-de-eventos)
  - [4.8. Notificações](#48-notificações)
  - [4.9. Organização dos Módulos](#49-organização-dos-módulos)
  - [4.10. Decisões Arquiteturais](#410-decisões-arquiteturais)
  - [4.11. Diagrama de Contextos](#411-diagrama-de-contextos)
- [5. Modelo de Domínio](#5-modelo-de-domínio)
  - [5.1. Visão Geral](#51-visão-geral)
  - [5.2. Agregados do Domínio](#52-agregados-do-domínio)
  - [5.3. Entidades do Domínio](#53-entidades-do-domínio)
  - [5.4. Relacionamentos](#54-relacionamentos)
  - [5.5. Value Objects](#55-value-objects)
  - [5.6. Invariantes do Domínio](#56-invariantes-do-domínio)
- [6. Eventos de Domínio](#6-eventos-de-domínio)
  - [6.1. Visão Geral](#61-visão-geral)
  - [6.2. Objetivos](#62-objetivos)
  - [6.3. Fluxo Geral](#63-fluxo-geral)
  - [6.4. Eventos do Contexto de Tenant](#64-eventos-do-contexto-de-tenant)
  - [6.5. Eventos do Contexto de Unidades](#65-eventos-do-contexto-de-unidades)
  - [6.6. Eventos do Contexto de Alunos](#66-eventos-do-contexto-de-alunos)
  - [6.7. Eventos do Contexto de Matrículas](#67-eventos-do-contexto-de-matrículas)
  - [6.8. Eventos do Contexto de Planos](#68-eventos-do-contexto-de-planos)
  - [6.9. Eventos do Contexto de Professores](#69-eventos-do-contexto-de-professores)
  - [6.10. Eventos do Contexto de Treinos](#610-eventos-do-contexto-de-treinos)
  - [6.11. Eventos Futuros](#611-eventos-futuros)
  - [6.12. Comunicação entre Contextos](#612-comunicação-entre-contextos)
  - [6.13. Diretrizes para Criação de Eventos](#613-diretrizes-para-criação-de-eventos)
  - [6.14. Implementação no GymFlow](#614-implementação-no-gymflow)
- [7. Notificações](#7-notificações)
  - [7.1. Visão Geral](#71-visão-geral)
  - [7.2. Objetivos](#72-objetivos)
  - [7.3. Arquitetura](#73-arquitetura)
  - [7.4. Fluxo de Funcionamento](#74-fluxo-de-funcionamento)
  - [7.5. Eventos Consumidos](#75-eventos-consumidos)
  - [7.6. Canais de Comunicação](#76-canais-de-comunicação)
  - [7.7. Templates de Notificação](#77-templates-de-notificação)
  - [7.8. Falhas no Envio](#78-falhas-no-envio)
  - [7.9. Extensibilidade](#79-extensibilidade)
  - [7.10. Responsabilidades do Módulo](#710-responsabilidades-do-módulo)
  - [7.11. Decisões Arquiteturais](#711-decisões-arquiteturais)
- [8. APIs REST](#8-apis-rest)
  - [8.1. Visão Geral](#81-visão-geral)
  - [8.2. Convenções Gerais](#82-convenções-gerais)
  - [8.3. Tenant API](#83-tenant-api)
  - [8.4. Units API](#84-units-api)
  - [8.5. Authentication API](#85-authentication-api)
  - [8.6. Students API](#86-students-api)
  - [8.7. Enrollments API](#87-enrollments-api)
  - [8.8. Plans API](#88-plans-api)
  - [8.9. Benefits API](#89-benefits-api)
  - [8.10. Trainings API](#810-trainings-api)
  - [8.11. Professors API](#811-professors-api)
  - [8.12. Códigos HTTP](#812-códigos-http)
  - [8.13. Princípios adotados](#813-princípios-adotados)
- [9. Modelo de Dados](#9-modelo-de-dados)
  - [9.1. Visão Geral](#91-visão-geral)
  - [9.2. Convenções de Modelagem](#92-convenções-de-modelagem)
  - [9.3. Entidades](#93-entidades)
  - [9.4. Relacionamentos](#94-relacionamentos)
  - [9.5. Restrições de Integridade](#95-restrições-de-integridade)
  - [9.6. Estratégia de Persistência](#96-estratégia-de-persistência)
  - [9.7. Índices Recomendados](#97-índices-recomendados)
- [10. Roadmap](#10-roadmap)
  - [10.1. Visão Geral](#101-visão-geral)
  - [10.2. MVP - Gestão de Academias](#102-mvp---gestão-de-academias)
  - [10.3. Fase 2 - Operação da Academia](#103-fase-2---operação-da-academia)
  - [10.4. Fase 3 - Financeiro](#104-fase-3---financeiro)
  - [10.5. Fase 4 - Aplicativo do Aluno](#105-fase-4---aplicativo-do-aluno)
  - [10.6. Fase 5 - Integrações](#106-fase-5---integrações)
  - [10.7. Evolução Arquitetural](#107-evolução-arquitetural)
  - [10.8. Evolução Tecnológica](#108-evolução-tecnológica)
  - [10.9. Critérios de Conclusão](#109-critérios-de-conclusão)
  - [10.10. Visão de Longo Prazo](#1010-visão-de-longo-prazo)

## 1. Visão do Produto

### 1.1. Objetivo do GymFlow

O GymFlow é um **Sistema de Gestão para Academias (SaaS - Software as a Service)** desenvolvido para simplificar e centralizar as operações de academias de pequeno e médio porte. A plataforma oferece um conjunto completo de ferramentas para o controle de alunos, planos, matrículas, treinos e comunicação, permitindo que os gestores foquem no que realmente importa: o crescimento do seu negócio.

O sistema busca resolver problemas comuns enfrentados por academias, como:

- Controle manual de alunos ativos e inadimplentes;
- Dificuldade em acompanhar mudanças de plano e inadimplência;
- Falta de histórico de matrículas e evolução dos alunos;
- Controle inadequado de fichas de treino e prescrições;
- Baixa visibilidade do desempenho e evolução dos alunos;
- Comunicação ineficiente entre academia, professores e alunos.

Com uma arquitetura **Multi-Tenant** desde o início, o GymFlow está preparado para atender uma única academia ou uma rede com múltiplas unidades, garantindo isolamento de dados e segurança.

### 1.2. Público-Alvo

O GymFlow é destinado a:

- academias de pequeno e médio porte;
- estúdios de treinamento;
- personal trainers com equipe;
- redes de academias com múltiplas unidades (evolução futura).

### 1.3. Escopo do MVP

A primeira versão do GymFlow (MVP) focará em funcionalidades essenciais para gestão de uma academia, incluindo:

- **Onboarding e Configurações:**
  - Cadastro de Academia (Tenant);
  - Cadastro de Unidades (suporte para múltiplas unidades, mas operações com uma por enquanto);
  - Criação do usuário Administrador;
- **Gestão de Pessoas:**
  - Cadastro de Alunos;
  - Cadastro de Professores;
- **Gestão de Planos e Matrículas:**
  - Cadastro de Planos e Benefícios;
  - Controle de Matrículas (criação, alteração de plano, cancelamento, inadimplência);
  - Alteração de Planos;
  - Controle de inadimplência e bloqueio de acesso;
- **Gestão de Treinos:**
  - Cadastro de Exercícios (Catalogo de Exercícios);
  - Criação de Ficha de Treino personalizadas;
  - Atribuição de Professores às Fichas de Treino;
  - Histórico de Treinos do Aluno;
- **Notificação e Comunicação:**
  - Notificações automáticas para alunos sobre:
    - Expiração de Ficha de Treino;
    - Alteração de Plano;
    - Inadimplência;
    - Vencimento de Matrícula.
    - Boas-vindas e mensagens de engajamento;
  - Notificações serão enviadas por e-mail e WhatsApp (via integração futura com WhatsApp Business API);
- **APIs e Integrações:**
  - API REST para integração futura com aplicativos e catracas físicas;
  - Publicação de eventos de domínio no Apache Kafka.

### 1.4. Fora do Escopo do MVP

- Integração com sistemas de pagamento (gateways);
- Integração com catracas físicas (hardware);
- Aplicativo mobile para alunos;
- Controle financeiro completo e fluxo de caixa;
- Agenda de alunos e professores;
- Avaliações físicas;
- Business Intelligence (BI) e relatórios avançados;
- Multi-unidade (para redes de academias);
- WhatsApp Business API para comunicação com alunos;

## 2. Regras de Negócio

As regras de negócio descritas nesta seção representam as restrições e comportamentos obrigatórios do domínio do GymFlow. Todas as funcionalidades do sistema deverão respeitar essas regras independentemente da interface utilizada (API REST, aplicação web, aplicativo móvel ou integrações futuras).

### 2.1. Academia (Tenant)

A Academia (Tenant) é a entidade central do sistema. Ela representa a organização que utiliza o GymFlow para gerenciar suas operações. Toda a informação no sistema pertence a uma Academia.

**RN-ACAD-001: Identificador da Academia**

- Cada Academia deve possuir um identificador único (Tenant ID), gerado automaticamente pelo sistema no momento do cadastro.

**RN-ACAD-002: CNPJ Único**

- O CNPJ é obrigatório para o cadastro de uma Academia.
- O sistema deve validar o formato do CNPJ e garantir a unicidade.
- Não será permitido cadastrar duas academias com o mesmo CNPJ.

**RN-ACAD-003: Status da Academia**

- Uma academia pode estar ativa ou inativa.
- Uma academia inativa não permite a realização de novas operações (criação de matrículas, treinos, etc.), mas os dados históricos permanecem para consulta.

### 2.2. Unidade

Uma Academia pode possuir uma ou mais Unidades (filiais). Cada Unidade representa uma localidade física onde os serviços são prestados.

**RN-UNID-001: Identificador da Unidade**

- Cada Unidade deve possuir um identificador único (UUID), gerado automaticamente pelo sistema no momento do cadastro.

**RN-UNID-002: Associação com Academia**

- Toda unidade deve estar obrigatoriamente vinculada a uma Academia (Tenant).
- Uma unidade não pode existe sem uma academia.

**RN-UNID-003: Unidade como referência**

- Alunos, Professores (Instrutores), Planos e Matrículas estão vinculados a uma Unidade, e consequentemente, a uma Academia.
- Uma unidade pode ter zero ou mais Alunos, Professores e Planos.

**RN-UNID-004: Status da Unidade**

- Uma unidade pode estar ativa ou inativa.
- Uma unidade inativa não permite a realização de novas operações (criação de matrículas, treinos, etc.), mas os dados históricos permanecem para consulta.

**RN-UNID-005: Acesso a informações de outras Unidades**

- Um usuário Administrador da Academia pode acessar informações de todas as Unidades.
- Um usuário Professor só pode acessar informações da Unidade à qual está vinculado.
- Um usuário Recepcionista só pode operar sobre informações da Unidade à qual está vinculado, porém pode consultar informações de outras Unidades.

### 2.3. Controle de Acesso

Responsável pela autenticação e autorização de usuários no sistema.

**RN-ACC-001: Autenticação Obrigatória**

- Todo acesso ao sistema, seja via interface web ou API, requer autenticação.
- Credenciais são o e-mail e senha do usuário.

**RN-ACC-002: Administrador da Academia**

- O sistema deve permitir a criação de um primeiro usuário (Administrador) durante o processo de onboarding (cadastro da Academia).
- O Administrador terá permissões totais sobre a sua Academia.

**RN-ACC-003: Hierarquia de Papéis (Futuro)**

- A estrutura de papéis (Admin > Gerente > Recepcionista > Professor) será introduzida em fases futuras.
- No MVP, apenas o papel Administrador será suportado.

### 2.4. Alunos

O aluno representa a pessoa que utiliza os serviços da academia. Seu cadastro é permanente dentro do sistema, independentemente da existência de uma matrícula ativa.

**RN-ALU-001: Identificador do Aluno**

- Cada aluno deve possuir um identificador único (UUID), gerado automaticamente pelo sistema no momento do cadastro.

**RN-ALU-002: CPF único**

- O CPF é obrigatório para o cadastro de um aluno.
- O sistema deve validar:
  - formato do CPF;
  - dígitos verificadores;
  - unicidade.
- Não será permitido cadastrar dois alunos utilizando o mesmo CPF.
- Um mesmo CPF pode ser cadastrado em academias diferentes

**RN-ALU-003: Permanência do cadastro**

- O cadastro do aluno nunca será removido em decorrência do cancelamento de uma matrícula.
- O aluno continuará existindo no sistema para preservar seu histórico.

**RN-ALU-004: Atualização cadastral**

- Dados cadastrais poderão ser atualizados a qualquer momento, exceto o CPF.
- Caso seja necessário uma correção no CPF por motivos legais, essa alteração deverá ser realizada exclusivamente por um administrador do sistema.

**RN-ALU-005: Associação com Unidade**

- Um Aluno deve estar vinculado a uma Unidade da Academia no momento do cadastro.

### 2.5. Matrículas

A matrícula representa o vínculo entre um aluno e um plano de assinatura.

Todas as regras relacionadas ao acesso do aluno à academia pertencem à matrícula e não ao cadastro do aluno.

**RN-MAT-001: Matrícula única ativa**

- Um aluno poderá possuir apenas uma matrícula com status ATIVA ou INADIMPLENTE por vez.

**RN-MAT-002: Criação de matrícula**

- Toda matrícula deverá estar obrigatoriamente vinculada:
  - a um aluno;
  - a um plano de assinatura.
- Não será permitido criar matrículas sem essas associações.

**RN-MAT-003: Status inicial**

- Toda nova matrícula será criada com status PENDENTE, aguardando confirmação do pagamento inicial.

**RN-MAT-004: Ativação da matrícula**

- Após a confirmação do pagamento, o status da matrícula deverá ser alterado para ATIVA.

**RN-MAT-005: Alteração de plano**

- A alteração de plano nunca modificará uma matrícula existente.
- O sistema deverá:
  - cancelar a matrícula atual;
  - registrar sua data de encerramento;
  - calcular eventuais créditos ou valores proporcionais;
  - criar uma nova matrícula vinculada ao novo plano.
- Essa regra garante a preservação do histórico de matrículas do aluno.

**RN-MAT-006: Histórico de matrículas**

- O histórico de matrículas será representado pelo conjunto de matrículas já existentes para o aluno.
- Não haverá uma entidade específica para histórico de matrículas.

**RN-MAT-007: Cancelamento de matrícula**

- O cancelamento de uma matrícula encerrará apenas aquele vínculo entre aluno e plano.
- O cadastro do aluno permanecerá disponível no sistema.

**RN-MAT-008: Inadimplência**

- Uma matrícula deverá ser considerada inadimplente quando permanecer por mais de cinco dias com pagamento pendente.

**RN-MAT-009: Bloqueio de acesso**

- Ao tornar-se inadimplente, o sistema deverá bloquear automaticamente o acesso do aluno às dependências da academia por meio da integração com o módulo de controle de acesso.

### 2.6. Planos e Benefícios

Os planos representam os serviços comercializados pela academia.

Cada plano poderá oferecer diferentes benefícios aos alunos.

**RN-PLA-001: Cadastro de Benefícios**

- Os benefícios deverão ser cadastrados previamente no sistema.

**RN-PLA-002: Associação entre planos e benefícios**

- Um plano poderá possuir zero ou mais benefícios.
- Um benefício poderá ser reutilizado em diferentes planos.

**RN-PLA-003: Exclusão de benefícios**

- Benefícios vinculados a planos não poderão ser removidos fisicamente.
- Caso deixem de ser utilizados, deverão ser desativados.

**RN-PLA-004: Desativação de planos**

- Planos vinculados a matrículas existentes não poderão ser excluídos.
- O sistema deverá permitir apenas sua desativação.

**RN-PLA-005: Matrículas existentes em planos desativados**

- A desativação de um plano não afetará alunos já matriculados.
- Essas matrículas permanecerão válidas até seu encerramento.

**RN-PLA-006: Alteração em planos**

- Alterações em nome, preço ou benefícios de um plano não modificarão automaticamente matrículas já existentes.
- As regras comerciais da academia definirão quando uma alteração deverá gerar uma nova contratação.

**RN-PLA-007: Planos por Unidade**

- Planos são específicos para uma Unidade.
- Um mesmo nome de plano pode existir em Unidades diferentes.
- Um mesmo plano pode existir em Unidades diferentes da mesma academia, porém cada plano será tratado como uma entidade distinta.

### 2.7. Professores

O professor representa o profissional responsável por ministrar aulas e acompanhar o desempenho dos alunos.

**RN-PRO-001: Identificador do Professor**

- Cada professor deve possuir um identificador único (UUID), gerado automaticamente pelo sistema no momento do cadastro.

**RN-PRO-002: CIP único por Academia**

- O CIP (Cadastro de Identificação Profissional) é obrigatório para o cadastro de um professor.
- O sistema deve validar o formato do CIP e garantir sua unicidade dentro do contexto de uma Academia.
- Não será permitido cadastrar dois professores utilizando o mesmo CIP na mesma Academia.

**RN-PRO-003: Permanência do cadastro**

- O cadastro do professor nunca será removido em decorrência do desligamento da academia.
- O professor continuará existindo no sistema para preservar seu histórico.

**RN-PRO-004: Atualização cadastral**

- Dados cadastrais poderão ser atualizados a qualquer momento, exceto o CIP.
- Caso seja necessário uma correção no CIP por motivos legais, essa alteração deverá ser realizada exclusivamente por um administrador do sistema.

**RN-PRO-005: Atribuição de treinos**

- O professor poderá ser atribuído a um ou mais treinos dentro de sua Unidade.
- O sistema deverá permitir a associação entre professores e treinos, garantindo que cada treino tenha um responsável.

**RN-PRO-006: Professores por Unidade**

- Um professor pode ser cadastrado em uma Unidade específica, mas poderá, a critério da administração, ser associado a treinos em outras Unidades.

### 2.8. Treinos

A ficha de treino representa uma prescrição elaborada por um professor para um aluno.

Ela não representa o catálogo de exercícios da academia.

**RN-TRN-001: Exclusividade da ficha de treino**

- Cada aluno poderá possuir apenas uma ficha de treino ativa por vez, dentro de uma Academia.
- A criação de uma nova ficha de treino deverá desativar a ficha anterior.

**RN-TRN-002: Atribuição de professor**

- Cada ficha de treino deverá estar obrigatoriamente vinculada a um professor responsável.

**RN-TRN-003: Criação de ficha de treino**

- Uma ficha será composta por diversos exercícios prescritos.
- Cada exercício prescrito armazenará informações como:
  - séries;
  - repetições;
  - carga sugerida;
  - descanso entre séries;
  - observações adicionais.
- Essas informações pertencem à prescrição, não ao exercício cadastrado.

**RN-TRN-004: Histórico de treinos**

- O histórico de treinos será representado pelo conjunto de fichas de treino já existentes para o aluno.
- Não haverá uma entidade específica para histórico de treinos.
- Fichas expiradas ou desativadas permanecerão disponíveis no sistema para consulta.

**RN-TRN-005: Validade da ficha de treino**

- O sistema deverá permitir definir a validade por:
  - data de expiração;
  - quantidade máxima de execuções;
- Após o vencimento, a ficha de treino será considerada expirada.

**RN-TRN-006: Acesso à ficha de treino**

- O acesso à ficha de treino será restrito ao aluno, professor, recepcionista e administrador, sendo vedado ao aluno e ao corpo de gestão da academia a alteração da ficha.

**RN-TRN-007: Vínculo com Unidade**

- Cada ficha de treino estará vinculada a uma Unidade da academia, garantindo que apenas professores e alunos daquela Unidade possam acessá-la.

### 2.9. Notificações

O envio de notificações faz parte do domínio do sistema e será realizado automaticamente através de eventos de negócio.

Não existirão endpoints REST responsáveis pelo disparo manual de notificações.

**RN-NOT-001: Expiração de ficha de treino**

- Ao expirar uma ficha de treino, o sistema deverá notificar o aluno.

**RN-NOT-002: Alteração de plano**

- Ao ocorrer alteração de plano, o sistema poderá notificar o aluno sobre a mudança.

**RN-NOT-003: Inadimplência**

- Ao identificar inadimplência, o sistema deverá comunicar o aluno antes do bloqueio definitivo de acesso.

**RN-NOT-004: Vencimento de matrícula**

- O sistema deverá notificar o aluno sobre o vencimento da matrícula antes do bloqueio de acesso.

**RN-NOT-005: Notificações de eventos**

- As notificações deverão ser desacopladas das regras de negócio, sendo executadas através de eventos de domínio e processadas pelo módulo de notificações.

**RN-NOT-006: Contexto das Notificações**

- As notificações são enviadas para os alunos de uma Unidade específica.

## 3. Casos de Uso

Os Casos de Uso descrevem como cada ator interage com o sistema para atingir um objetivo específico, considerando apenas o comportamento esperado do domínio.

Detalhes de implementação, persistência de dados e infraestrutura não fazem parte desta seção.

### 3.1. Academia

---

**UC-ACAD-001: Cadastrar Academia**

- **Objetivo**
  - Permitir que uma nova academia se registre no sistema GymFlow.
- **Atores**
  - Administrador do sistema
  - Usuário Externo (Potencial cliente)
- **Pré-condições**
  - A academia ainda não está cadastrada no sistema.
- **Fluxo Principal**
  1. O ator inicia o processo de onboarding.
  2. O sistema solicita os dados da academia.
  3. O ator informa os dados obrigatórios.
  4. O sistema valida o CNPJ e verifica unicidade.
  5. O sistema registra a academia (Tenant) com status PENDENTE.
  6. O sistema cria o usuário Administrador da academia.
  7. O sistema envia um e-mail de confirmação para o Administrador.
  8. O Administrador confirma o e-mail e ativa a conta.
  9. O ator seleciona o plano de assinatura desejado.
  10. O sistema registra a assinatura e gera a fatura inicial.
  11. O sistema aguarda a confirmação do pagamento.
  12. Após a confirmação do pagamento, o sistema ativa a academia e altera status para ATIVO.
- **Fluxo Alternativo**
  - FA-01: CNPJ inválido ou já cadastrado
    - O sistema informa o erro e solicita correção.
  - FA-02: Falha na criação do usuário Administrador
    - O sistema informa o erro e solicita a criação de um novo usuário.
  - FA-03: Falha na confirmação do pagamento
    - O sistema informa o erro e solicita a tentativa de pagamento novamente.
- **Pós-condições**
  - A academia está cadastrada e ativa no sistema.
  - O Administrador possui acesso à plataforma.
- **Regras de Negócio Relacionadas**
  - RN-ACAD-001: Identificador da Academia
  - RN-ACAD-002: CNPJ Único
  - RN-ACAD-003: Status da Academia

---

**UC-ACAD-002: Atualizar Dados da Academia**

- **Objetivo**
  - Permitir que o Administrador atualize os dados cadastrais da academia.
- **Atores**
  - Administrador da academia
- **Pré-condições**
  - A academia está cadastrada e ativa no sistema.
- **Fluxo Principal**
  1. O ator acessa a seção de configurações da academia.
  2. O sistema exibe os dados atuais da academia.
  3. O ator altera os campos desejados (exceto CNPJ).
  4. O sistema valida os dados e confirma a atualização.
- **Fluxo Alternativo**
  - FA-01: Dados inválidos
    - O sistema informa o erro e solicita correção.
- **Pós-condições**
  - Os dados da academia são atualizados no sistema.
- **Regras de Negócio Relacionadas**
  - RN-ACAD-001: Identificador da Academia
  - RN-ACAD-003: Status da Academia

---

**UC-ACAD-003: Desativar Academia**

- **Objetivo**
  - Permitir que o Administrador desative a academia no sistema.
- **Atores**
  - Administrador da academia
- **Pré-condições**
  - A academia está cadastrada e ativa no sistema.
- **Fluxo Principal**
  1. O ator acessa a seção de configurações da academia.
  2. O sistema exibe a opção de desativação.
  3. O ator confirma a desativação da academia.
  4. O sistema altera o status da academia para INATIVO.
- **Fluxo Alternativo**
  - FA-01: Falha na desativação
    - O sistema informa o erro e solicita nova tentativa.
- **Pós-condições**
  - A academia está desativada no sistema, impedindo novas operações.
- **Regras de Negócio Relacionadas**
  - RN-ACAD-003: Status da Academia

---

**UC-ACAD-004: Consultar Academia**

- **Objetivo**
  - Permitir que o Administrador consulte os dados da academia.
- **Atores**
  - Administrador da academia
- **Pré-condições**
  - A academia está cadastrada no sistema.
- **Fluxo Principal**
  1. O ator acessa a seção de configurações da academia.
  2. O sistema exibe os dados atuais da academia.
- **Pós-condições**
  - O ator visualiza as informações da academia.
- **Regras de Negócio Relacionadas**
  - RN-ACAD-001: Identificador da Academia
  - RN-ACAD-002: CNPJ Único
  - RN-ACAD-003: Status da Academia

---

**UC-ACAD-005: Consultar Assinatura da Academia**

- **Objetivo**
  - Permitir que o Administrador consulte os detalhes da assinatura da academia.
- **Atores**
  - Administrador da academia
- **Pré-condições**
  - A academia está cadastrada no sistema.
- **Fluxo Principal**
  1. O ator acessa a seção de assinaturas da academia.
  2. O sistema exibe os detalhes da assinatura atual, incluindo plano, status e histórico de pagamentos.
- **Pós-condições**
  - O ator visualiza as informações da assinatura da academia.
- **Regras de Negócio Relacionadas**
  - RN-ACAD-001: Identificador da Academia
  - RN-ACAD-003: Status da Academia

---

### 3.2. Unidade

---

**UC-UNID-001: Cadastrar Unidade**

- **Objetivo**
  - Permitir que o Administrador cadastre uma nova unidade da academia.
- **Atores**
  - Administrador da academia
  - Gerente da unidade (futuro)
- **Pré-condições**
  - A academia está cadastrada e ativa no sistema.
- **Fluxo Principal**
  1. O ator acessa a seção de unidades da academia.
  2. O sistema solicita os dados da nova unidade.
  3. O ator informa os dados obrigatórios.
  4. O sistema valida os dados e verifica unicidade do nome da unidade.
  5. O sistema registra a unidade com status ATIVO.
- **Fluxo Alternativo**
  - FA-01: Dados inválidos ou nome da unidade já cadastrado
    - O sistema informa o erro e solicita correção.
- **Pós-condições**
  - A unidade está cadastrada e ativa no sistema.
- **Regras de Negócio Relacionadas**
  - RN-UNID-001: Identificador da Unidade
  - RN-UNID-002: Associação com Academia
  - RN-UNID-003: Unidade como referência
  - RN-UNID-004: Status da Unidade

---

**UC-UNID-002: Atualizar Dados da Unidade**

- **Objetivo**
  - Permitir que o Administrador atualize os dados cadastrais de uma unidade.
- **Atores**
  - Administrador da academia
  - Gerente da unidade (futuro)
- **Pré-condições**
  - A unidade está cadastrada e ativa no sistema.
- **Fluxo Principal**
  1. O ator acessa a seção de unidades da academia.
  2. O sistema exibe os dados atuais da unidade selecionada.
  3. O ator altera os campos desejados (exceto identificador).
  4. O sistema valida os dados e confirma a atualização.
- **Fluxo Alternativo**
  - FA-01: Dados inválidos
    - O sistema informa o erro e solicita correção.
- **Pós-condições**
  - Os dados da unidade são atualizados no sistema.
- **Regras de Negócio Relacionadas**
  - RN-UNID-001: Identificador da Unidade
  - RN-UNID-004: Status da Unidade

---

**UC-UNID-003: Desativar Unidade**

- **Objetivo**
  - Permitir que o Administrador desative uma unidade da academia.
- **Atores**
  - Administrador da academia
  - Gerente da unidade (futuro)
- **Pré-condições**
  - A unidade está cadastrada e ativa no sistema.
- **Fluxo Principal**
  1. O ator acessa a seção de unidades da academia.
  2. O sistema exibe a opção de desativação para a unidade selecionada.
  3. O ator confirma a desativação da unidade.
  4. O sistema altera o status da unidade para INATIVO.
- **Fluxo Alternativo**
  - FA-01: Falha na desativação
    - O sistema informa o erro e solicita nova tentativa.
- **Pós-condições**
  - A unidade está desativada no sistema, impedindo novas operações.
- **Regras de Negócio Relacionadas**
  - RN-UNID-004: Status da Unidade

---

**UC-UNID-004: Consultar Unidade**

- **Objetivo**
  - Permitir que o Administrador consulte os dados de uma unidade.
- **Atores**
  - Administrador da academia
  - Gerente da unidade (futuro)
- **Pré-condições**
  - A unidade está cadastrada no sistema.
- **Fluxo Principal**
  1. O ator acessa a seção de unidades da academia.
  2. O sistema exibe os dados atuais da unidade selecionada.
- **Pós-condições**
  - O ator visualiza as informações da unidade.
- **Regras de Negócio Relacionadas**
  - RN-UNID-001: Identificador da Unidade
  - RN-UNID-002: Associação com Academia
  - RN-UNID-003: Unidade como referência
  - RN-UNID-004: Status da Unidade

---

**UC-UNID-005: Consultar Unidades da Academia**

- **Objetivo**
  - Permitir que o Administrador consulte todas as unidades cadastradas da academia.
- **Atores**
  - Administrador da academia
- **Pré-condições**
  - A academia está cadastrada no sistema.
- **Fluxo Principal**
  1. O ator acessa a seção de unidades da academia.
  2. O sistema exibe a lista de todas as unidades cadastradas, incluindo status e informações básicas.
- **Pós-condições**
  - O ator visualiza a lista completa de unidades da academia.
- **Regras de Negócio Relacionadas**
  - RN-UNID-001: Identificador da Unidade
  - RN-UNID-002: Associação com Academia
  - RN-UNID-003: Unidade como referência
  - RN-UNID-004: Status da Unidade

---

**UC-UNID-006: Consultar Alunos por Unidade**

- **Objetivo**
  - Permitir que o Administrador consulte todos os alunos vinculados a uma unidade específica.
- **Atores**
  - Administrador da academia
  - Gerente da unidade (futuro)
  - Recepcionista da unidade (futuro)
- **Pré-condições**
  - A unidade está cadastrada no sistema.
- **Fluxo Principal**
  1. O ator acessa a seção de unidades da academia.
  2. O sistema exibe a lista de unidades cadastradas.
  3. O ator seleciona uma unidade específica.
  4. O sistema exibe a lista de todos os alunos vinculados à unidade selecionada, incluindo status e informações básicas.
- **Pós-condições**
  - O ator visualiza a lista completa de alunos da unidade selecionada.
- **Regras de Negócio Relacionadas**
  - RN-UNID-001: Identificador da Unidade
  - RN-UNID-002: Associação com Academia
  - RN-UNID-003: Unidade como referência
  - RN-UNID-004: Status da Unidade

---

**UC-UNID-007: Consultar Professores por Unidade**

- **Objetivo**
  - Permitir que o Administrador consulte todos os professores vinculados a uma unidade específica.
- **Atores**
  - Administrador da academia
  - Gerente da unidade (futuro)
  - Recepcionista da unidade (futuro)
- **Pré-condições**
  - A unidade está cadastrada no sistema.
- **Fluxo Principal**
  1. O ator acessa a seção de unidades da academia.
  2. O sistema exibe a lista de unidades cadastradas.
  3. O ator seleciona uma unidade específica.
  4. O sistema exibe a lista de todos os professores vinculados à unidade selecionada, incluindo status e informações básicas.
- **Pós-condições**
  - O ator visualiza a lista completa de professores da unidade selecionada.
- **Regras de Negócio Relacionadas**
  - RN-UNID-001: Identificador da Unidade
  - RN-UNID-002: Associação com Academia
  - RN-UNID-003: Unidade como referência
  - RN-UNID-004: Status da Unidade

---

**UC-UNID-008: Consultar Planos por Unidade**

- **Objetivo**
  - Permitir que o Administrador consulte todos os planos vinculados a uma unidade específica.
- **Atores**
  - Administrador da academia
  - Gerente da unidade (futuro)
  - Recepcionista da unidade (futuro)
- **Pré-condições**
  - A unidade está cadastrada no sistema.
- **Fluxo Principal**
  1. O ator acessa a seção de unidades da academia.
  2. O sistema exibe a lista de unidades cadastradas.
  3. O ator seleciona uma unidade específica.
  4. O sistema exibe a lista de todos os planos vinculados à unidade selecionada, incluindo status e informações básicas.
- **Pós-condições**
  - O ator visualiza a lista completa de planos da unidade selecionada.
- **Regras de Negócio Relacionadas**
  - RN-UNID-001: Identificador da Unidade
  - RN-UNID-002: Associação com Academia
  - RN-UNID-003: Unidade como referência
  - RN-UNID-004: Status da Unidade

---

### 3.3. Controle de Acesso

---

**UC-ACC-001: Autenticar Usuário**

- **Objetivo**
  - Permitir que um usuário se autentique no sistema utilizando suas credenciais.
- **Atores**
  - Usuário (Administrador, Professor, Recepcionista)
- **Pré-condições**
  - O usuário possui uma conta válida no sistema.
- **Fluxo Principal**
  1. O ator acessa a tela de login do sistema.
  2. O sistema solicita o e-mail e senha do usuário.
  3. O ator informa suas credenciais.
  4. O sistema valida as credenciais.
  5. Se válidas, o sistema autentica o usuário e concede acesso ao sistema.
- **Fluxo Alternativo**
  - FA-01: Credenciais inválidas
    - O sistema informa o erro e solicita nova tentativa de login.
- **Pós-condições**
  - O usuário está autenticado e pode acessar as funcionalidades permitidas pelo seu papel.
- **Regras de Negócio Relacionadas**
  - RN-ACC-001: Autenticação Obrigatória
  - RN-ACC-002: Administrador da Academia

---

**UC-ACC-002: Recuperar Senha**

- **Objetivo**
  - Permitir que um usuário recupere sua senha caso a tenha esquecido.
- **Atores**
  - Usuário (Administrador, Professor, Recepcionista)
- **Pré-condições**
  - O usuário possui uma conta válida no sistema.
- **Fluxo Principal**
  1. O ator acessa a tela de login do sistema.
  2. O sistema exibe a opção "Esqueci minha senha".
  3. O ator seleciona essa opção e informa seu e-mail cadastrado.
  4. O sistema valida o e-mail e envia um link de recuperação para o endereço informado.
  5. O ator acessa o link recebido por e-mail.
  6. O sistema solicita a criação de uma nova senha.
  7. O ator informa a nova senha e confirma.
  8. O sistema atualiza a senha do usuário e confirma a alteração.
- **Fluxo Alternativo**
  - FA-01: E-mail não cadastrado
    - O sistema informa o erro e solicita correção ou novo e-mail.
- **Pós-condições**
  - A senha do usuário é atualizada com sucesso, permitindo novo acesso ao sistema.
- **Regras de Negócio Relacionadas**
  - RN-ACC-001: Autenticação Obrigatória
  - RN-ACC-002: Administrador da Academia

---

**UC-ACC-003: Alterar Senha**

- **Objetivo**
  - Permitir que um usuário altere sua senha de acesso ao sistema.
- **Atores**
  - Usuário (Administrador, Professor, Recepcionista)
- **Pré-condições**
  - O usuário está autenticado no sistema.
- **Fluxo Principal**
  1. O ator acessa a seção de configurações de sua conta.
  2. O sistema exibe a opção de alteração de senha.
  3. O ator informa a senha atual e a nova senha desejada.
  4. O sistema valida a senha atual e confirma a alteração para a nova senha.
- **Fluxo Alternativo**
  - FA-01: Senha atual incorreta
    - O sistema informa o erro e solicita nova tentativa.
- **Pós-condições**
  - A senha do usuário é alterada com sucesso, permitindo novo acesso ao sistema com a nova senha.
- **Regras de Negócio Relacionadas**
  - RN-ACC-001: Autenticação Obrigatória
  - RN-ACC-002: Administrador da Academia

---

**UC-ACC-004: Gerenciar Papéis de Usuário (Futuro)**

- **Objetivo**
  - Permitir que o Administrador gerencie os papéis e permissões dos usuários dentro da academia.
- **Atores**
  - Administrador da academia
- **Pré-condições**
  - O usuário está autenticado como Administrador.
- **Fluxo Principal**
  1. O ator acessa a seção de gerenciamento de usuários.
  2. O sistema exibe a lista de usuários cadastrados na academia.
  3. O ator seleciona um usuário específico para gerenciar seu papel.
  4. O sistema exibe as opções de papéis disponíveis (Admin, Gerente, Recepcionista, Professor).
  5. O ator altera o papel do usuário conforme necessário.
  6. O sistema confirma a alteração e atualiza as permissões do usuário.
- **Fluxo Alternativo**
  - FA-01: Tentativa de atribuir papel inválido
    - O sistema informa o erro e solicita correção.
- **Pós-condições**
  - O papel do usuário é atualizado com sucesso, refletindo as novas permissões no sistema.
- **Regras de Negócio Relacionadas**
  - RN-ACC-001: Autenticação Obrigatória
  - RN-ACC-003: Hierarquia de Papéis (Futuro)

---

**UC-ACC-005: Revogar Acesso de Usuário**

- **Objetivo**
  - Permitir que o Administrador revogue o acesso de um usuário à academia.
- **Atores**
  - Administrador da academia
- **Pré-condições**
  - O usuário está autenticado como Administrador.
- **Fluxo Principal**
  1. O ator acessa a seção de gerenciamento de usuários.
  2. O sistema exibe a lista de usuários cadastrados na academia.
  3. O ator seleciona um usuário específico para revogar seu acesso.
  4. O sistema solicita confirmação da ação.
  5. O ator confirma a revogação do acesso.
  6. O sistema atualiza o status do usuário para revogado, impedindo novo acesso ao sistema.
- **Fluxo Alternativo**
  - FA-01: Tentativa de revogar acesso de um usuário inexistente
    - O sistema informa o erro e solicita nova seleção.
- **Pós-condições**
  - O acesso do usuário é revogado com sucesso, impedindo novo login no sistema.
- **Regras de Negócio Relacionadas**
  - RN-ACC-001: Autenticação Obrigatória
  - RN-ACC-002: Administrador da Academia

---

**UC-ACC-006: Consultar Usuários da Academia**

- **Objetivo**
  - Permitir que o Administrador consulte todos os usuários cadastrados na academia.
- **Atores**
  - Administrador da academia
- **Pré-condições**
  - O usuário está autenticado como Administrador.
- **Fluxo Principal**
  1. O ator acessa a seção de gerenciamento de usuários.
  2. O sistema exibe a lista completa de usuários cadastrados na academia, incluindo status e informações básicas.
- **Pós-condições**
  - O ator visualiza a lista completa de usuários da academia.
- **Regras de Negócio Relacionadas**
  - RN-ACC-001: Autenticação Obrigatória
  - RN-ACC-002: Administrador da Academia

---

**UC-ACC-007: Consultar Papéis e Permissões (Futuro)**

- **Objetivo**
  - Permitir que o Administrador consulte os papéis e permissões disponíveis no sistema.
- **Atores**
  - Administrador da academia
- **Pré-condições**
  - O usuário está autenticado como Administrador.
- **Fluxo Principal**
  1. O ator acessa a seção de gerenciamento de usuários.
  2. O sistema exibe a lista de papéis disponíveis, juntamente com suas respectivas permissões.
- **Pós-condições**
  - O ator visualiza os papéis e permissões disponíveis no sistema.
- **Regras de Negócio Relacionadas**
  - RN-ACC-001: Autenticação Obrigatória
  - RN-ACC-003: Hierarquia de Papéis (Futuro)

---

**UC-ACC-008: Cadastrar Novo Usuário (Futuro)**

- **Objetivo**
  - Permitir que o Administrador cadastre novos usuários na academia.
- **Atores**
  - Administrador da academia
- **Pré-condições**
  - O usuário está autenticado como Administrador.
- **Fluxo Principal**
  1. O ator acessa a seção de gerenciamento de usuários.
  2. O sistema exibe a opção de cadastrar novo usuário.
  3. O ator informa os dados obrigatórios do novo usuário, incluindo e-mail, nome e papel.
  4. O sistema valida os dados e verifica unicidade do e-mail.
  5. O sistema registra o novo usuário e envia um e-mail de confirmação para o endereço informado.
- **Fluxo Alternativo**
  - FA-01: E-mail já cadastrado
    - O sistema informa o erro e solicita correção.
- **Pós-condições**
  - O novo usuário é cadastrado com sucesso e recebe instruções para ativar sua conta.
- **Regras de Negócio Relacionadas**
  - RN-ACC-001: Autenticação Obrigatória
  - RN-ACC-002: Administrador da Academia

---

### 3.4. Aluno

---

**UC-ALU-001: Cadastrar Aluno**

- **Objetivo**
  - Permitir que o Recepcionista cadastre um novo aluno na academia.
- **Atores**
  - Administrador da academia
  - Recepcionista da unidade
- **Pré-condições**
  - O aluno ainda não está cadastrado.
  - O CPF do aluno é válido e não está em uso.
- **Fluxo Principal**
  1. O ator inicia o cadastro de um novo aluno;
  2. O sistema solicita os dados cadastrais;
  3. O ator informa os dados obrigatórios;
  4. O sistema valida o CPF;
  5. O sistema verifica se já existe um aluno com o mesmo CPF;
  6. O sistema registra o aluno.
- **Fluxo Alternativo**
  - FA-01: CPF Inválido
    - O sistema informa que o CPF é inválido e solicita sua correção.
  - FA-02: CPF já cadastrado
    - O sistema informa que o CPF já está em uso e solicita outro CPF.
- **Pós-condições**
  - O aluno encontra-se cadastrado e apto para receber uma matrícula.
- **Regras de Negócio Relacionadas**
  - RN-ALU-001: Identificador do Aluno
  - RN-ALU-002: CPF Único
  - RN-ALU-003: Status do Aluno
  - RN-ALU-004: Permanência do cadastro
  - RN-ALU-005: Atualização cadastral

---

**UC-ALU-002: Atualizar Cadastro de Aluno**

- **Objetivo**
  - Permitir a atualização das informações cadastrais de um aluno.
- **Atores**
  - Recepcionista
  - Administrador
- **Pré-condições**
  - O aluno já está cadastrado no sistema.
- **Fluxo Principal**
  1. O ator localiza o aluno.
  2. O sistema apresenta os dados atuais.
  3. O ator realiza as alterações necessárias nos dados do aluno.
  4. O sistema valida os novos dados.
  5. O sistema salva as alterações no cadastro do aluno.
- **Fluxos Alternativos**
  - FA-01: Aluno não encontrado
    - O sistema informa que o aluno não foi localizado.
- **Pós-condições**
  - As informações cadastrais permanecem atualizadas.
- **Regras de Negócio Relacionadas**
  - RN-ALU-004: Permanência do cadastro
  - RN-ALU-005: Atualização cadastral

---

### 3.5. Matrícula

---

**UC-MAT-001: Criar Matrícula**

- **Objetivo**
  - Vincular um aluno a um plano de assinatura.
- **Atores**
  - Recepcionista
  - Administrador
- **Pré-condições**
  - O aluno já está cadastrado no sistema.
  - O plano de assinatura já está cadastrado no sistema e ativo.
  - O aluno não possui uma matrícula ativa ou inadimplente.
- **Fluxo Principal**
  1. O ator seleciona o aluno.
  2. O sistema apresenta os planos disponíveis.
  3. O ator escolhe o plano desejado.
  4. O sistema cria a matrícula com status **_PENDENTE_**.
- **Fluxos Alternativos**
  - FA-01: Aluno já possui matrícula ativa ou inadimplente
    - O sistema impede a criação da matrícula.
  - FA-02: Plano indisponível ou inativo
    - O sistema informa que o plano não pode ser utilizado.
- **Pós-condições**
  - Uma nova matrícula é criada.
- **Regras de Negócio Relacionadas**
  - RN-MAT-001: Matrícula única ativa
  - RN-MAT-002: Criação de matrícula
  - RN-MAT-003: Status inicial
  - RN-MAT-004: Ativação da matrícula

---

**UC-MAT-002: Alterar Plano**

- **Objetivo**
  - Permitir a alteração do plano de assinatura de uma matrícula existente.
- **Atores**
  - Recepcionista
  - Administrador
- **Pré-condições**
  - O aluno já possui uma matrícula ativa.
  - O novo plano de assinatura está cadastrado e ativo.
- **Fluxo Principal**
  1. O ator seleciona a matrícula do aluno.
  2. O sistema apresenta os planos disponíveis.
  3. O ator escolhe o novo plano desejado.
  4. O sistema encerrará a matrícula atual, registrando sua data de encerramento.
  5. O sistema calcula valores proporcionais ou créditos, se aplicável.
  6. O sistema cria uma nova matrícula vinculada ao novo plano.
- **Fluxos Alternativos**
  - FA-01: Aluno não possui matrícula ativa
    - O sistema informa que não é possível alterar o plano sem uma matrícula ativa.
  - FA-02: Novo plano indisponível ou inativo
    - O sistema informa que o novo plano não pode ser utilizado.
- **Pós-condições**
  - A matrícula anterior permanece registrada como encerrada e uma nova matrícula passa a representar o vínculo atual do aluno.
- **Regras de Negócio Relacionadas**
  - RN-MAT-005: Alteração de plano
  - RN-MAT-006: Histórico de matrículas

---

**UC-MAT-003: Cancelar Matrícula**

- **Objetivo**
  - Encerrar o vínculo entre aluno e plano.
- **Atores**
  - Recepcionista
  - Administrador
- **Pré-condições**
  - O aluno já possui uma matrícula ativa ou inadimplente.
- **Fluxo Principal**
  1. O ator seleciona a matrícula do aluno.
  2. O sistema solicita a confirmação do cancelamento.
  3. O ator confirma o cancelamento.
  4. O sistema encerra a matrícula, registrando sua data de encerramento.
- **Fluxos Alternativos**
  - FA-01: Aluno não possui matrícula ativa ou inadimplente
    - O sistema informa que não é possível cancelar uma matrícula inexistente.
- **Pós-condições**
  - A matrícula é encerrada, o aluno não possui mais vínculo com o plano e o aluno permanece cadastrado.
- **Regras de Negócio Relacionadas**
  - RN-MAT-007: Cancelamento de matrícula

---

**UC-MAT-004: Processar Inadimplência**

- **Objetivo**
  - Atualizar automaticamente as matrículas inadimplentes.
- **Atores**
  - Sistema (automático)
- **Pré-condições**
  - A matrícula está com pagamento pendente há mais de cinco dias.
- **Fluxo Principal**
  1. O sistema identifica matrículas com pagamentos em atraso.
  2. O sistema altera o status para **_INADIMPLENTE_**.
  3. O sistema bloqueia o acesso do aluno.
  4. O sistema publica um evento de inadimplência para o módulo de notificações.
- **Pós-condições**
  - A matrícula é marcada como inadimplente, o aluno é notificado e seu acesso é bloqueado.
- **Regras de Negócio Relacionadas**
  - RN-MAT-008: Inadimplência
  - RN-MAT-009: Bloqueio de acesso
  - RN-NOT-003: Inadimplência

---

### 3.6. Planos

---

**UC-PLA-001: Cadastrar Plano**

- **Objetivo**
  - Permitir o cadastro de um novo plano de assinatura.
- **Atores**
  - Administrador
- **Pré-condições**
  - O plano ainda não está cadastrado no sistema.
- **Fluxo Principal**
  1. O ator inicia o cadastro de um novo plano.
  2. O sistema solicita os dados do plano.
  3. O ator informa os dados obrigatórios.
  4. O sistema registra o plano.
- **Pós-condições**
  - O plano encontra-se cadastrado e disponível para futuras matrículas.
- **Regras de Negócio Relacionadas**
  - RN-PLA-001: Cadastro de benefícios
  - RN-PLA-002: Associação entre planos e benefícios

---

**UC-PLA-002: Alterar Plano**

- **Objetivo**
  - Permitir a atualização das informações de um plano existente.
- **Atores**
  - Administrador
- **Pré-condições**
  - O plano já está cadastrado no sistema.
- **Fluxo Principal**
  1. O ator seleciona o plano a ser alterado.
  2. O sistema apresenta os dados atuais do plano.
  3. O ator realiza as alterações necessárias.
  4. O sistema atualiza o plano.
- **Pós-condições**
  - As informações do plano permanecem atualizadas.
- **Regras de Negócio Relacionadas**
  - RN-PLA-006: Alteração em planos

---

**UC-PLA-003: Desativar Plano**

- **Objetivo**
  - Permitir a desativação de um plano existente.
- **Atores**
  - Administrador
- **Pré-condições**
  - O plano já está cadastrado no sistema.
- **Fluxo Principal**
  1. O ator seleciona o plano a ser desativado.
  2. O sistema solicita a confirmação da desativação.
  3. O ator confirma a desativação.
  4. O sistema desativa o plano.
- **Pós-condições**
  - O plano é marcado como inativo e não poderá ser utilizado para novas matrículas.
- **Regras de Negócio Relacionadas**
  - RN-PLA-004: Desativação de planos
  - RN-PLA-005: Matrículas existentes em planos desativados

---

### 3.7. Benefícios

---

**UC-BEN-001: Cadastrar Benefício**

- **Objetivo**
  - Permitir o cadastro de um novo benefício.
- **Atores**
  - Administrador
- **Pré-condições**
  - O benefício ainda não está cadastrado no sistema.
- **Fluxo Principal**
  1. O ator inicia o cadastro de um novo benefício.
  2. O sistema solicita os dados do benefício.
  3. O ator informa os dados obrigatórios.
  4. O sistema registra o benefício.
- **Pós-condições**
  - O benefício encontra-se cadastrado e disponível para associação a planos.
- **Regras de Negócio Relacionadas**
  - RN-PLA-001: Cadastro de benefícios

---

**UC-BEN-002: Alterar Benefício**

- **Objetivo**
  - Permitir a atualização das informações de um benefício existente.
- **Atores**
  - Administrador
- **Pré-condições**
  - O benefício já está cadastrado no sistema.
- **Fluxo Principal**
  1. O ator seleciona o benefício a ser alterado.
  2. O sistema apresenta os dados atuais do benefício.
  3. O ator realiza as alterações necessárias.
  4. O sistema atualiza o benefício.
- **Pós-condições**
  - As informações do benefício permanecem atualizadas.
- **Regras de Negócio Relacionadas**
  - RN-PLA-001: Cadastro de benefícios
  - RN-PLA-002: Associação entre planos e benefícios

---

**UC-BEN-003: Desativar Benefício**

- **Objetivo**
  - Permitir a desativação de um benefício existente.
- **Atores**
  - Administrador
- **Pré-condições**
  - O benefício já está cadastrado no sistema.
- **Fluxo Principal**
  1. O ator seleciona o benefício a ser desativado.
  2. O sistema solicita a confirmação da desativação.
  3. O ator confirma a desativação.
  4. O sistema desativa o benefício.
- **Pós-condições**
  - O benefício é marcado como inativo e não poderá ser utilizado para associação a novos planos.
- **Regras de Negócio Relacionadas**
  - RN-PLA-003: Exclusão de benefícios

---

**UC-BEN-004: Associar Benefício a Plano**

- **Objetivo**
  - Permitir a associação de um benefício a um plano existente.
- **Atores**
  - Administrador
- **Pré-condições**
  - O benefício e o plano já estão cadastrados no sistema.
- **Fluxo Principal**
  1. O ator seleciona o plano ao qual deseja associar o benefício.
  2. O sistema apresenta os benefícios disponíveis.
  3. O ator escolhe o benefício desejado.
  4. O sistema associa o benefício ao plano.
- **Pós-condições**
  - O benefício passa a fazer parte do conjunto de benefícios do plano selecionado.
- **Regras de Negócio Relacionadas**
  - RN-PLA-002: Associação entre planos e benefícios

---

### 3.8. Professores

---

**UC-PRO-001: Cadastrar Professor**

- **Objetivo**
  - Permitir o cadastro de um novo professor no sistema.
- **Atores**
  - Administrador
- **Pré-condições**
  - O professor ainda não está cadastrado no sistema.
- **Fluxo Principal**
  1. O ator inicia o cadastro de um novo professor.
  2. O sistema solicita os dados cadastrais.
  3. O ator informa os dados obrigatórios.
  4. O sistema valida o CIP.
  5. O sistema verifica se já existe um professor com o mesmo CIP.
  6. O sistema registra o professor.
- **Fluxos Alternativos**
  - FA-01: CIP inválido
    - O sistema informa que o CIP é inválido e solicita sua correção.
  - FA-02: CIP já cadastrado
    - O sistema informa que o CIP já está em uso e solicita outro CIP.
- **Pós-condições**
  - O professor encontra-se cadastrado e apto para ministrar aulas e prescrever treinos.
- **Regras de Negócio Relacionadas**
  - RN-PRO-001: Identificador do Professor
  - RN-PRO-002: CIP único
  - RN-PRO-003: Permanência do cadastro
  - RN-PRO-004: Atualização cadastral

---

**UC-PRO-002: Atualizar Cadastro de Professor**

- **Objetivo**
  - Permitir a atualização das informações cadastrais de um professor.
- **Atores**
  - Administrador
- **Pré-condições**
  - O professor já está cadastrado no sistema.
- **Fluxo Principal**
  1. O ator localiza o professor.
  2. O sistema apresenta os dados atuais.
  3. O ator realiza as alterações necessárias nos dados do professor.
  4. O sistema valida os novos dados.
  5. O sistema atualiza o cadastro do professor.
- **Fluxos Alternativos**
  - FA-01: Professor não encontrado
    - O sistema informa que o professor não foi localizado.
- **Pós-condições**
  - As informações cadastrais permanecem atualizadas.
- **Regras de Negócio Relacionadas**
  - RN-PRO-004: Atualização cadastral

---

**UC-PRO-003: Desativar Professor**

- **Objetivo**
  - Permitir a desativação de um professor existente.
- **Atores**
  - Administrador
- **Pré-condições**
  - O professor já está cadastrado no sistema.
- **Fluxo Principal**
  1. O ator seleciona o professor a ser desativado.
  2. O sistema solicita a confirmação da desativação.
  3. O ator confirma a desativação.
  4. O sistema desativa o professor.
- **Pós-condições**
  - O professor é marcado como inativo e não poderá ser associado a novos treinos.
- **Regras de Negócio Relacionadas**
  - RN-PRO-003: Permanência do cadastro

---

**UC-PRO-004: Atribuir Professor a Treino**

- **Objetivo**
  - Permitir a associação de um professor a um treino existente.
- **Atores**
  - Administrador
- **Pré-condições**
  - O professor e o treino já estão cadastrados no sistema.
- **Fluxo Principal**
  1. O ator seleciona o treino ao qual deseja atribuir o professor.
  2. O sistema apresenta os professores disponíveis.
  3. O ator escolhe o professor desejado.
  4. O sistema associa o professor ao treino.
- **Pós-condições**
  - O professor passa a ser responsável pelo treino selecionado.
- **Regras de Negócio Relacionadas**
  - RN-PRO-005: Atribuição de treinos

---

### 3.9. Ficha de Treinos

---

**UC-TRN-001: Criar Ficha de Treino**

- **Objetivo**
  - Criar uma nova prescrição de treino para um aluno.
- **Atores**
  - Professor
  - Administrador
- **Pré-condições**
  - O aluno já possui matrícula ativa.
  - O professor está cadastrado e ativo no sistema.
- **Fluxo Principal**
  1. O ator seleciona o aluno para o qual deseja criar a ficha de treino.
  2. O sistema apresenta o catálogo de exercícios disponíveis.
  3. O ator adiciona exercícios à ficha.
  4. Para cada exercício adicionado, o ator define:
  - séries;
  - repetições;
  - carga sugerida;
  - descanso entre séries;
  - observações adicionais.
  5. O ator define a validade da ficha.
  6. O sistema encerra automaticamente a ficha anterior, caso exista.
  7. O sistema registra a nova ficha de treino.
- **Fluxos Alternativos**
  - FA-01: Aluno não possui matrícula ativa
    - O sistema informa que não é possível criar uma ficha de treino sem uma matrícula ativa.
  - FA-02: Professor não cadastrado ou inativo
    - O sistema informa que o professor não pode ser atribuído à ficha de treino.
- **Pós-condições**
  - Uma nova ficha de treino é criada e associada ao aluno e ao professor responsável.
- **Regras de Negócio Relacionadas**
  - RN-TRN-001: Exclusividade da ficha de treino
  - RN-TRN-002: Atribuição de professor
  - RN-TRN-003: Criação de ficha de treino
  - RN-TRN-005: Validade da ficha de treino
  - RN-TRN-006: Acesso à ficha de treino

---

**UC-TRN-002: Consultar Ficha de Treino**

- **Objetivo**
  - Permitir a visualização da ficha de treino de um aluno.
- **Atores**
  - Professor
  - Aluno
- **Pré-condições**
  - O aluno possui uma ficha de treino ativa.
  - O professor é responsável pela ficha de treino ou o aluno é o titular da ficha.
- **Fluxo Principal**
  1. O ator seleciona o aluno cuja ficha deseja consultar.
  2. O sistema verifica se o ator tem permissão para acessar a ficha.
  3. O sistema apresenta os detalhes da ficha de treino, incluindo:
  - exercícios prescritos;
  - séries e repetições;
  - carga sugerida;
  - descanso entre séries;
  - observações adicionais.
- **Fluxos Alternativos**
  - FA-01: Acesso negado
    - O sistema informa que o ator não tem permissão para acessar a ficha de treino.
  - FA-02: Ficha de treino não encontrada
    - O sistema informa que não existe uma ficha de treino ativa para o aluno selecionado.
- **Pós-condições**
  - A ficha de treino é exibida ao ator autorizado.
- **Regras de Negócio Relacionadas**
  - RN-TRN-006: Acesso à ficha de treino

---

**UC-TRN-003: Consultar Histórico de Treinos**

- **Objetivo**
  - Permitir a visualização do histórico de fichas de treino de um aluno.
- **Atores**
  - Professor
  - Aluno
- **Pré-condições**
  - O aluno possui fichas de treino anteriores registradas no sistema.
  - O professor é responsável por alguma das fichas ou o aluno é o titular das fichas.
- **Fluxo Principal**
  1. O ator seleciona o aluno cujo histórico deseja consultar.
  2. O sistema verifica se o ator tem permissão para acessar o histórico.
  3. O sistema apresenta a lista de fichas de treino anteriores, incluindo:
  - datas de criação e expiração;
  - exercícios prescritos;
  - séries e repetições;
  - carga sugerida;
  - descanso entre séries;
  - observações adicionais.
- **Fluxos Alternativos**
  - FA-01: Acesso negado
    - O sistema informa que o ator não tem permissão para acessar o histórico de treinos.
  - FA-02: Histórico não encontrado
    - O sistema informa que não existem fichas de treino registradas para o aluno selecionado.
- **Pós-condições**
  - O histórico de treinos é exibido ao ator autorizado.
- **Regras de Negócio Relacionadas**
  - RN-TRN-004: Histórico de treinos

---

**UC-TRN-004: Registrar Evolução do Aluno**

- **Objetivo**
  - Permitir o registro da evolução do aluno em relação à ficha de treino.
- **Atores**
  - Professor
- **Pré-condições**
  - O aluno possui uma ficha de treino ativa.
  - O professor é responsável pela ficha de treino.
- **Fluxo Principal**
  1. O ator seleciona o aluno cuja evolução deseja registrar.
  2. O sistema apresenta a ficha de treino atual.
  3. O ator registra informações sobre a evolução do aluno, incluindo:
  - desempenho nos exercícios;
  - ajustes na carga ou repetições;
  - observações adicionais.
  4. O sistema salva as informações de evolução no histórico do aluno.
- **Fluxos Alternativos**
  - FA-01: Acesso negado
    - O sistema informa que o ator não tem permissão para registrar a evolução do aluno.
  - FA-02: Ficha de treino não encontrada
    - O sistema informa que não existe uma ficha de treino ativa para o aluno selecionado.
- **Pós-condições**
  - A evolução do aluno é registrada e associada à sua ficha de treino.
- **Regras de Negócio Relacionadas**
  - RN-TRN-006: Acesso à ficha de treino

---

**UC-TRN-005: Notificar Expiração de Ficha de Treino**

- **Objetivo**
  - Notificar automaticamente o aluno sobre a expiração de sua ficha de treino.
- **Atores**
  - Sistema (automático)
- **Pré-condições**
  - A ficha de treino do aluno está prestes a expirar ou já expirou.
- **Fluxo Principal**
  1. O sistema identifica fichas de treino próximas da data de expiração ou já expiradas.
  2. O sistema envia uma notificação ao aluno informando sobre a expiração da ficha.
- **Pós-condições**
  - O aluno é informado sobre a necessidade de atualizar ou renovar sua ficha de treino.
- **Regras de Negócio Relacionadas**
  - RN-NOT-001: Expiração de ficha de treino

---

## 4. Arquitetura do Sistema

### 4.1. Visão Geral

O GymFlow será desenvolvido como um Monólito Modular, organizado em módulos de negócio independentes e de baixo acoplamento.

Cada módulo será responsável por um contexto específico do domínio da aplicação, possuindo suas próprias regras de negócio, casos de uso, entidades e interfaces.

Essa organização permite que o sistema evolua de forma incremental, mantendo alta coesão entre os componentes e facilitando testes, manutenção e futuras integrações.

Embora seja um monólito, sua estrutura foi projetada para que determinados módulos possam ser extraídos para microsserviços no futuro, caso haja necessidade.

### 4.2 Princípios Arquiteturais

O GymFlow seguirá os seguintes princípios arquiteturais:

- **Arquitetura Hexagonal (Ports and Adapters)**;
- **Domain-Driven Design (DDD)**;
- **Spring Modulith para modularização interna**;
- **Baixo acoplamento entre os módulos**;
- **Alta coesão dentro de cada módulo**;
- **Comunicação prefencial através de eventos de domínio**;
- **Separação entre domínio, aplicação e infraestrutura**;
- **Persistência desacoplada da lógica de negócio**;

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

- Spring;
- Hibernate;
- PostgreSQL;
- REST;
- Mensageria.

### 4.4 Bounded Contexts

O domínio do GymFlow foi dividido em contextos independentes, cada um responsável por um conjunto específico de regras de negócio.

- **Tenant Context:**
  - Responsável pelo gerenciamento dos dados da academia (tenant).
  - **Responsabilidades:**
    - Cadastro de academias;
    - Atualização de dados cadastrais;
    - Configuração de planos e benefícios disponíveis;
    - Gerenciamento de usuários e permissões.
  - **Não é responsável por:**
    - Cadastro de alunos;
    - Matrículas;
    - Pagamentos;
    - Treinos.

- **Access Control Context:**
  - Responsável pelo gerenciamento de usuários, papéis e permissões.
  - **Responsabilidades:**
    - Cadastro de usuários;
    - Atribuição de papéis e permissões;
    - Autenticação e autorização.
  - **Não é responsável por:**
    - Cadastro de alunos;
    - Matrículas;
    - Pagamentos;
    - Treinos.

- **Unit Context:**
  - Responsável pelo gerenciamento das unidades da academia.
  - **Responsabilidades:**
    - Cadastro de unidades;
    - Atribuição de usuários a unidades;
    - Configuração de horários e recursos disponíveis.
  - **Não é responsável por:**
    - Cadastro de alunos;
    - Matrículas;
    - Pagamentos;
    - Treinos.

- **Student Context:**
  - Responsável pelo gerenciamento cadastral dos alunos.
  - **Responsabilidades:**
    - Cadastro de alunos;
    - Atualização de dados cadastrais;
    - Validar CPF e outros identificadores;
    - Consultar histórico de alunos.
    - Consultar alunos por matrícula ou ficha de treino.
  - **Não é responsável por:**
    - Matrículas;
    - Pagamentos;
    - Treinos.

- **Enrollment Context:**
  - Responsável pelo gerenciamento das matrículas dos alunos.
  - **Responsabilidades:**
    - Criação de matrículas;
    - Cancelamento;
    - Alteração de planos;
    - Inadimplência;
    - Bloqueio de acesso;
  - **Não é responsável por:**
    - Cadastro de alunos;
    - Cadastro de planos;
    - Cadastro de benefícios;
    - Treinos.

  Esse contexto representa o vínculo comercial entre aluno e academia.

- **Plan Context:**
  - Responsável pelo gerenciamento dos planos comercializados pela academia.
  - **Responsabilidades:**
    - Cadastro de planos;
    - Cadastro de benefícios;
    - Alteração de planos;
    - Exclusão de planos;
    - Precificação de planos;
    - Disponibilidade.
  - **Não é responsável por:**
    - Cadastro de alunos;
    - Matrículas;
    - Pagamentos;
    - Treinos.

- **Training Context:**
  - Responsável pelo gerenciamento das fichas de treino e acompanhamento do desempenho dos alunos.
  - **Responsabilidades:**
    - Criação de fichas de treino;
    - Atribuição de professores;
    - Registro de evolução do aluno;
    - Consulta de histórico de treinos.
  - **Não é responsável por:**
    - Cadastro de alunos;
    - Matrículas;
    - Pagamentos;
    - Planos e benefícios.

- **Notification Context:**
  - Responsável pelo envio de notificações automáticas aos alunos.
  - **Responsabilidades:**
    - Notificação de expiração de ficha de treino;
    - Notificação de alteração de plano;
    - Notificação de inadimplência;
    - Notificação de vencimento de matrícula.
  - **Não é responsável por:**
    - Cadastro de alunos;
    - Matrículas;
    - Pagamentos;
    - Planos e benefícios;
    - Treinos.

- **Payment Context (Futuro)**
  - Responsável pela integração com catracas e controle de acesso.
  - Inicialmente existirá apenas como interface para futuras integrações.

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

- **Matrículas**
  - EnrollmentCreated
  - EnrollmentActivated
  - EnrollmentCanceled
  - EnrollmentPlanChanged
  - EnrollmentBecameOverdue
- **Treinos**
  - TrainingSheetCreated
  - TrainingSheetExpired
- **Planos**
  - PlanCreated
  - PlanUpdated
  - PlanDeactivated
- **Alunos**
  - StudentCreated
  - StudentUpdated
- **Notificações**
  - NotificationSent
  - NotificationFailed

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
| Arquitetura Hexagonal   | Isolar regras de negócio da infraestrutura e facilitar testes.                                                |
| Domain-Driven Design    | Modelar o software de acordo com o domínio da academia.                                                       |
| Eventos de Domínio      | Reduzir acoplamento entre módulos e permitir extensibilidade.                                                 |
| UUID como identificador | Evitar dependência de identificadores sequenciais e facilitar integrações futuras.                            |
```

### 4.11 Diagrama de Contextos

O diagrama abaixo ilustra a hierarquia e a comunicação entre os contextos delimitados do GymFlow.

```text
┌───────────────────────────────────────────────────────────────┐
│                     Tenant Context                           │
│               (Academia / SaaS Provider)                     │
└───────────────────────────┬───────────────────────────────────┘
                            │
        ┌───────────────────┼───────────────────┐
        ▼                   ▼                   ▼
┌───────────────┐   ┌───────────────┐   ┌───────────────┐
│   Unit        │   │   Access      │   │   Student     │
│   Context     │   │   Control     │   │   Context     │
│               │   │   Context     │   │               │
└───────────────┘   └───────────────┘   └───────────────┘
        │                   │                   │
        └───────────────────┼───────────────────┘
                            │
        ┌───────────────────┼───────────────────┐
        ▼                   ▼                   ▼
┌───────────────┐   ┌───────────────┐   ┌───────────────┐
│   Plan        │   │   Enrollment  │   │   Training    │
│   Context     │   │   Context     │   │   Context     │
│               │   │               │   │               │
└───────────────┘   └───────┬───────┘   └───────────────┘
                            │
                            ▼
                ┌───────────────────────┐
                │    Notification       │
                │    Context            │
                └───────────────────────┘
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
| Tenant     | Tenant           | Dados da Academia                        |
| Unit       | Unit             | Unidades/Filiais da Academia             |
| User       | User             | Usuários do sistema (Admin, etc.)        |
| Student    | Student          | Dados cadastrais do aluno                |
| Enrollment | Enrollment       | Vínculo entre aluno e plano              |
| Plan       | Plan             | Planos comercializados e seus benefícios |
| Training   | TrainingSheet    | Prescrição de treinos                    |
| Instructor | Instructor       | Cadastro dos professores                 |
```

Cada agregado possui uma única Aggregate Root, responsável por garantir a integridade das regras de negócio.

### 5.3 Entidades do Domínio

- **Tenant**<br>
  Representa a academia (ou SaaS Provider) que utiliza o sistema.
  - **Responsabilidades:**
    - armazenar informações cadastrais da academia;
    - controlar a disponibilidade do sistema para a academia;
    - servir como referência para usuários, planos e unidades.

  - **Atributos:**
    ```text
    | Campo     | Descrição          |
    | --------- | ------------------ |
    | id        | UUID               |
    | name      | Nome da academia   |
    | legalName | Razão social       |
    | tradeName | Nome fantasia      |
    | cnpj      | CNPJ (único)       |
    | email     | E-mail             |
    | phone     | Telefone           |
    | status    | Status da academia |
    | address   | Endereço           |
    | createdAt | Data de cadastro   |
    | updatedAt | Última atualização |
    ```
  - **Regras importantes:**
    - não conhece alunos, matrículas, planos ou treinos;
    - não possui status de ativo/inativo, permanecendo cadastrado mesmo após o cancelamento de matrículas;
    - não conhece planos;
    - não conhece pagamentos;

- **Unit**<br>
  Representa uma unidade física da academia, podendo haver múltiplas unidades para uma mesma academia.
  - **Responsabilidades:**
    - armazenar informações cadastrais da unidade;
    - servir como referência para usuários, planos e treinos.

  - **Atributos:**
    ```text
    | Campo     | Descrição          |
    | --------- | ------------------ |
    | id        | UUID               |
    | tenantId  | UUID               |
    | name      | Nome da unidade    |
    | email     | E-mail             |
    | phone     | Telefone           |
    | address   | Endereço           |
    | createdAt | Data de cadastro   |
    | updatedAt | Última atualização |
    ```
  - **Regras importantes:**
    - não conhece alunos, matrículas, planos ou treinos;
    - não conhece planos;
    - não conhece pagamentos;

- **User**<br>
  Representa um usuário do sistema, podendo ser administrador, recepcionista ou gerente.
  - **Responsabilidades:**
    - armazenar informações cadastrais do usuário;
    - controlar permissões e papéis;
    - servir como referência para autenticação e autorização.

  - **Atributos:**
    ```text
    | Campo     | Descrição          |
    | --------- | ------------------ |
    | id        | UUID               |
    | tenantId  | UUID               |
    | unitId    | UUID               |
    | fullName  | Nome completo      |
    | email     | E-mail (único)     |
    | password  | Senha              |
    | role      | Papel do usuário   |
    | status    | Status do usuário  |
    | createdAt | Data de cadastro   |
    | updatedAt | Última atualização |
    ```
  - **Regras importantes:**
    - não conhece alunos, matrículas, planos ou treinos;
    - não possui status de ativo/inativo, permanecendo cadastrado mesmo após o cancelamento de matrículas;
    - não conhece planos;
    - não conhece pagamentos;

- **Student**<br>
  Representa um aluno da academia, contendo informações pessoais e de contato.
  - **Responsabilidades:**
    - armazenar informações cadastrais;
    - indentificar unicamente um aluno;
    - servir como referência para matrículas e fichas de treino.

  - **Atributos:**
    ```text
    | Campo     | Descrição          |
    | --------- | ------------------ |
    | id        | UUID               |
    | tenantId  | UUID               |
    | unitId    | UUID               |
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
  - **Regras importantes:**
    - não possui status de ativo/inativo, permanecendo cadastrado mesmo após o cancelamento de matrículas;
    - não conhece planos;
    - não conhece pagamentos;
    - pode possuir múltiplas matrículas ao longo do tempo, mas apenas uma matrícula ativa por vez.

---

- **Enrollment**<br>
  Representa o vínculo comercial entre um aluno e a academia.

  É uma das entidades mais importantes do domínio.
  - **Responsabilidades:**
    - registrar a associação entre aluno e plano;
    - controlar o status da matrícula (ativa, pendente, cancelada, inadimplente);
    - servir como referência para notificações e bloqueio de acesso.
    - controlar o ciclo de vida da matrícula, incluindo datas de início e término.
    - representar mudanças de plano como novas matrículas, mantendo o histórico completo do aluno.
    - controlar inadimplência, bloqueando o acesso do aluno quando necessário.

  - **Atributos:**

    ```text
    | Campo       | Descrição                       |
    | ----------- | ------------------------------- |
    | id          | UUID                            |
    | studentId   | Referência ao Student           |
    | planId      | Referência ao Plan              |
    | tenantId    | Referência ao Tenant            |
    | unitId      | Referência ao Unit              |
    | status      | Situação da matrícula           |
    | startDate   | Data de início                  |
    | endDate     | Data de término (se aplicável)  |
    | dueDay      | Dia de vencimento               |
    | createdAt   | Data de criação                 |
    | updatedAt   | Última atualização              |
    ```

  - **Regras importantes:**
    - apenas uma matrícula ativa por aluno;
    - mudança de plano gera nova matrícula;
    - cancelamento encerra a matrícula;
    - inadimplência pertence à matrícula.

---

- **Plan**<br>
  Representa um plano de assinatura oferecido pela academia.
  - **Responsabilidades:**
    - armazenar informações sobre o plano;
    - controlar a disponibilidade do plano;
    - associar benefícios ao plano.
    - definir preço e condições de pagamento;

  - **Atributos:**

    ```text
    | Campo       | Descrição                                |
    | ----------- | -----------------------------------------|
    | id          | UUID                                     |
    | tenantId    | Referência ao Tenant                     |
    | unitId      | Referência ao Unit                       |
    | name        | Nome do plano                            |
    | description | Descrição do plano                       |
    | price       | Preço do plano                           |
    | isActive    | Disponibilidade do plano                 |
    | createdAt   | Data de criação                          |
    | updatedAt   | Última atualização                       |
    | benefits    | Lista de benefícios associados ao plano  |
    ```

  - **Regras importantes:**
    - planos podem ser ativados ou desativados;
    - planos desativados não podem ser utilizados para novas matrículas;
    - planos podem ter múltiplos benefícios associados.

---

- **Benefit**<br>
  Representa um benefício associado a um plano de assinatura.

  Exemplos:
  - Estacionamento
  - Avaliação Física
  - Armário
  - Área Premium
  - Aulas Coletivas
  - Piscina
  - Sauna

  - **Responsabilidades:**
    - armazenar informações sobre o benefício;
    - ser associado a planos.

  - **Atributos:**

    ```text
    | Campo       | Descrição                       |
    | ----------- | ------------------------------- |
    | id          | UUID                            |
    | tenantId    | Referência ao Tenant            |
    | unitId      | Referência ao Unit              |
    | name        | Nome do benefício               |
    | description | Descrição do benefício          |
    | isActive    | Disponibilidade do benefício    |
    | createdAt   | Data de criação                 |
    | updatedAt   | Última atualização              |
    ```

  - **Regras importantes:**
    - benefícios podem ser ativados ou desativados;
    - benefícios desativados não podem ser associados a novos planos.

---

- **Instructor**<br>
  Representa um professor da academia, responsável por prescrever treinos e acompanhar a evolução dos alunos.
  - **Responsabilidades:**
    - armazenar informações cadastrais do professor;
    - ser associado a fichas de treino;
    - registrar evolução dos alunos;
    - criar treinos e prescrever exercícios para os alunos;
    - atualizar treinos e registrar a evolução dos alunos;
    - acompanhar alunos.

  - **Atributos:**

    ```text
    | Campo     | Descrição                                    |
    | --------- | -------------------------------------------- |
    | id        | UUID                                         |
    | tenantId  | Referência ao Tenant                         |
    | unitId    | Referência ao Unit                           |
    | fullName  | Nome completo                                |
    | cip       | Código de identificação do professor (único) |
    | email     | E-mail                                       |
    | phone     | Telefone                                     |
    | isActive  | Disponibilidade do professor                 |
    | createdAt | Data de cadastro                             |
    | updatedAt | Última atualização                           |
    ```

  - **Regras importantes:**
    - cada professor possui um CIP único;
    - professores podem ser ativados ou desativados;
    - professores desativados não podem ser atribuídos a novas fichas de treino.

---

- **Exercise**<br>
  Representa um exercício físico que pode ser incluído em uma ficha de treino.
  - **Responsabilidades:**
    - armazenar informações sobre o exercício;
    - ser associado a fichas de treino.

  - **Atributos:**

    ```text
    | Campo       | Descrição                               |
    | ----------- | --------------------------------------- |
    | id          | UUID                                    |
    | tenantId    | Referência ao Tenant                    |
    | name        | Nome do exercício                       |
    | description | Descrição do exercício                  |
    | isActive    | Disponibilidade do exercício            |
    | videoUrl    | URL do vídeo demonstrativo do exercício |
    | imageUrl    | URL da imagem do exercício              |
    | createdAt   | Data de criação                         |
    | updatedAt   | Última atualização                      |
    ```

    > > **Importante:** Um exercício não possui informações como séries, repetições ou carga. Esses dados pertencem à prescrição do treino.

  - **Regras importantes:**
    - exercícios podem ser ativados ou desativados;
    - exercícios desativados não podem ser incluídos em novas fichas de treino.

---

- **TrainingSheet**<br>
  Representa a prescrição de treino de um aluno, contendo os exercícios, séries, repetições e carga sugerida.
  - **Responsabilidades:**
    - armazenar informações sobre a prescrição de treino;
    - ser associado a um aluno e a um professor;
    - registrar a evolução do aluno;
    - agrupar exercícios em uma ficha de treino, com detalhes como séries, repetições, carga e descanso;
    - controlar validade;
    - manter histórico de fichas de treino para cada aluno.

  - **Atributos:**

    ```text
    | Campo          | Descrição                              |
    | -------------- | -------------------------------------- |
    | id             | UUID                                   |
    | studentId      | Referência ao Student                  |
    | instructorId   | Referência ao Instructor               |
    | tenantId       | Referência ao Tenant                   |
    | unitId         | Referência ao Unit                     |
    | title          | Título da ficha de treino              |
    | exercises      | Lista de exercícios prescritos         |
    | startDate      | Data de início da prescrição           |
    | endDate        | Data de término da prescrição          |
    | expirationDate | Data de expiração da prescrição        |
    | isActive       | Indica se a ficha de treino está ativa |
    | createdAt      | Data de criação                        |
    | updatedAt      | Última atualização                     |
    ```

  - **Regras importantes:**
    - cada aluno possui apenas uma ficha de treino ativa por vez;
    - fichas de treino possuem validade definida;
    - fichas expiradas não podem ser utilizadas para novos treinos.

---

- **TrainingSheetExercise**<br>
  Esta entidade representa a prescrição de um exercício dentro de uma ficha de treino.

  Ela faz a associação entre uma ficha e um exercício do catálogo.
  - **Responsabilidades:**
    - definir como o exercício será realizado dentro da ficha de treino;
    - armazenar parâmetros específicos de prescrição.

  - **Atributos:**

    ```text
    | Campo            | Descrição                       |
    | ---------------- | ------------------------------- |
    | id               | UUID                            |
    | trainingSheetId  | Referência à TrainingSheet      |
    | exerciseId       | Referência ao Exercise          |
    | tenantId         | Referência ao Tenant            |
    | unitId           | Referência ao Unit              |
    | order            | Ordem do exercício na ficha     |
    | sets             | Número de séries                |
    | repetitions      | Número de repetições            |
    | load             | Carga sugerida                  |
    | restTime         | Tempo de descanso entre séries  |
    | observations     | Observações adicionais          |
    ```

  - **Regras importantes:**
    - cada exercício em uma ficha de treino possui suas próprias prescrições;
    - alterações na prescrição de um exercício não afetam outras fichas de treino.

---

### 5.4 Relacionamentos

```text
Tenant (1) ----< Unit (N)
   │                 │
   │                 │ (1)
   │                 │
   │                 └----< Student (N)
   │                 │
   │                 └----< Instructor (N)
   │                 │
   │                 └----< Plan (N)
   │
   └----< User (N) (Admin)

Student (1) ----< Enrollment (N) ---- (1) Plan (1) ----< Benefit (N)

Instructor (1) ----< TrainingSheet (N) ---- (1) Student (1)

TrainingSheet (1) ----< TrainingExercise (N) ---- (1) Exercise (N)
```

### 5.5 Value Objects

Nem tudo no domínio precisa ser uma entidade identificada por um UUID. Alguns conceitos existem apenas pelo seu valor e não possuem identidade própria.

Para o GymFlow, os principais Value Objects são:

```text
| Value Object | Descrição                                                                                   |
| ------------ | ------------------------------------------------------------------------------------------- |
| CPF          | Responsável por validar formato e dígitos verificadores.                                    |
| CNPJ         | Responsável por validar formato e dígitos verificadores.                                    |
| Email        | Garante formato válido e normalização.                                                      |
| Phone        | Representa um telefone no padrão adotado pela aplicação.                                    |
| Address      | Agrupa informações de endereço (logradouro, número, complemento, bairro, cidade, UF e CEP). |
| Money        | Representa valores monetários de forma segura, evitando problemas de precisão com `double`. |
```

Esses objetos encapsulam regras de validação e comportamento, reduzindo duplicação de código nas entidades.

### 5.6 Invariantes do Domínio

As seguintes regras devem ser garantidas pelo domínio, independentemente da interface utilizada:

- Um aluno não pode possuir mais de uma matrícula ativa.
- Uma matrícula deve estar vinculada a exatamente um aluno e um plano.
- Um plano pode conter vários benefícios.
- Um benefício pode ser compartilhado por vários planos.
- Uma ficha de treino deve pertencer a um único aluno.
- Uma ficha deve possuir exatamente um professor responsável.
- Um exercício pode aparecer em diversas fichas de treino.
- As informações de séries, repetições, carga e descanso pertencem à prescrição (TrainingExercise), e não ao exercício (Exercise).

## 6. Eventos de Domínio

### 6.1 Visão Geral

Os Eventos de Domínio representam acontecimentos relevantes dentro do negócio da academia.

Sempre que uma operação resultar em uma mudança significativa no estado do sistema, um evento poderá ser publicado para que outros módulos reajam de forma independente.

Essa abordagem reduz o acoplamento entre os módulos, melhora a manutenibilidade do sistema e facilita a evolução para integrações futuras.

Os eventos descritos nesta seção representam apenas acontecimentos do domínio, não detalhes técnicos de implementação.

### 6.2 Objetivos

A utilização de eventos de domínio possui os seguintes objetivos:

- desacoplar os módulos do sistema;
- permitir comunicação assíncrona entre contextos;
- facilitar futuras integrações externas;
- evitar dependências diretas entre regras de negócio;
- tornar o domínio mais expressivo.

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

### 6.4 Eventos do Contexto de Tenant
- **TenantCreatedEvent**:
  - **Descrição:** Publicado quando uma nova academia é cadastrada.
  - **Origem**: Tenant Context
  - **Consumidores:** ProvisioningConsumer e Notification Context
  - **Objetivo:** Permitir ações posteriores ao cadastro, como provisionamento de recursos e envio de e-mail de boas-vindas.
- **TenantUpdatedEvent**:
  - **Descrição:** Publicado quando os dados de uma academia são atualizados.
  - **Origem**: Tenant Context
  - **Consumidores:** Notificaiton Context
  - **Objetivo:** Permitir ações posteriores à atualização, como envio de confirmação de alteração.
- **TenantDeactivatedEvent**:
  - **Descrição:** Publicado quando uma academia é desativada.
  - **Origem**: Tenant Context
  - **Consumidores:** Notification Context
  - **Objetivo:** Permitir ações posteriores à desativação, como envio de aviso de desativação e bloqueio de acesso a recursos.

### 6.5 Eventos do Contexto de Unidades
  - **UnitCreatedEvent**:
    - **Descrição:** Publicado quando uma nova unidade é cadastrada.
    - **Origem**: Unit Context
    - **Consumidores:** Notification Context
    - **Objetivo:** Permitir ações posteriores ao cadastro, como envio de mensagem de boas-vindas.
  - **UnitUpdatedEvent**:
    - **Descrição:** Publicado quando os dados de uma unidade são atualizados.
    - **Origem**: Unit Context
    - **Consumidores:** Notification Context
    - **Objetivo:** Permitir ações posteriores à atualização, como envio de confirmação de alteração.
  - **UnitDeactivatedEvent**:
    - **Descrição:** Publicado quando uma unidade é desativada.
    - **Origem**: Unit Context
    - **Consumidores:** Notification Context
    - **Objetivo:** Permitir ações posteriores à desativação, como envio de aviso de desativação e bloqueio de acesso a recursos.

### 6.6 Eventos do Contexto de Alunos

- **StudentRegisteredEvent**:
  - **Descrição:** Publicado quando um novo aluno é cadastrado.
  - **Origem**: Student Context
  - **Consumidores:** Notification Context
  - **Objetivo:** Permitir ações posteriores ao cadastro, como envio de mensagem de boas-vindas.
- **StudentUpdatedEvent**:
  - **Descrição:** Publicado quando os dados de um aluno são atualizados.
  - **Origem**: Student Context
  - **Consumidores:** Notification Context
  - **Objetivo:** Permitir ações posteriores à atualização, como envio de confirmação de alteração.

### 6.7 Eventos do Contexto de Matrículas

- **EnrollmentCreatedEvent**:
  - **Descrição:** Publicado quando uma nova matrícula é criada.
  - **Origem**: Enrollment Context
  - **Consumidores:** Notification Context
  - **Objetivo:** Notificar sobre a criação da matrícula e permitir ações relacionadas à prescrição de treinos.
  - **Possíveis Ações:** Enviar confirmação de matrícula, registrar auditoria, iniciar processos futuros.
- **EnrollmentActivatedEvent**:
  - **Descrição:** Publicado quando o pagamento inicial é confirmado.
  - **Origem**: Enrollment Context
  - **Consumidores:** Notification Context, Access Control Context (futuro)
  - **Objetivo:** Notificar sobre a ativação da matrícula e permitir ações relacionadas à prescrição de treinos.
  - **Possíveis Ações:** Enviar boas-vindas, liberar acesso a recursos, iniciar acompanhamento de treinos.
- **EnrollmentCanceledEvent**:
  - **Descrição:** Publicado quando uma matrícula é cancelada.
  - **Origem**: Enrollment Context
  - **Consumidores:** Notification Context, Access Control Context (futuro)
  - **Objetivo:** Notificar sobre o cancelamento da matrícula e permitir ações relacionadas à prescrição de treinos.
  - **Possíveis Ações:** Enviar confirmação de cancelamento, revogar acesso a recursos, atualizar histórico do aluno.
- **EnrollmentPlanChangedEvent**:
  - **Descrição:** Publicado quando um aluno altera seu plano.
  - **Origem**: Enrollment Context
  - **Consumidores:** Notification Context, Access Control Context (futuro)
  - **Objetivo:** Notificar sobre a alteração do plano e permitir ações relacionadas à prescrição de treinos.
  - **Possíveis Ações:** Enviar confirmação de alteração, atualizar benefícios e recursos disponíveis, ajustar acompanhamento de treinos.
- **EnrollmentBecameOverdueEvent**:
  - **Descrição:** Publicado quando uma matrícula se torna inadimplente.
  - **Origem**: Enrollment Context
  - **Consumidores:** Notification Context, Access Control Context (futuro)
  - **Objetivo:** Notificar sobre a inadimplência e permitir ações relacionadas à prescrição de treinos.
  - **Possíveis Ações:** Enviar aviso de inadimplência, bloquear acesso a recursos, iniciar processo de cobrança (futuro).

### 6.8 Eventos do Contexto de Planos

- **PlanCreatedEvent**:
  - **Descrição:** Publicado quando um novo plano é criado.
  - **Origem**: Plan Context
  - **Consumidores:** Notification Context
  - **Objetivo:** Notificar sobre a criação do plano e permitir ações relacionadas à prescrição de treinos.
  - **Possíveis Ações:** Enviar confirmação de criação, atualizar catálogo de planos disponíveis, iniciar campanhas de marketing (futuro).
- **PlanUpdatedEvent**:
  - **Descrição:** Publicado quando um plano existente é atualizado.
  - **Origem**: Plan Context
  - **Consumidores:** Notification Context
  - **Objetivo:** Notificar sobre a atualização do plano e permitir ações relacionadas à prescrição de treinos.
  - **Possíveis Ações:** Enviar confirmação de atualização, ajustar benefícios e recursos disponíveis, atualizar documentação do plano.
- **PlanDeactivatedEvent**:
  - **Descrição:** Publicado quando um plano é desativado.
  - **Origem**: Plan Context
  - **Consumidores:** Notification Context
  - **Objetivo:** Notificar sobre a desativação do plano e permitir ações relacionadas à prescrição de treinos.
  - **Possíveis Ações:** Enviar aviso de desativação, atualizar catálogo de planos disponíveis, ajustar matrículas existentes (futuro).

### 6.9 Eventos do Contexto de Professores

- **InstructorCreatedEvent**:
  - **Descrição:** Publicado quando um novo professor é cadastrado.
  - **Origem**: Instructor Context
  - **Consumidores:** Notification Context
  - **Objetivo:** Notificar sobre o cadastro do professor e permitir ações relacionadas à prescrição de treinos.
  - **Possíveis Ações:** Enviar confirmação de cadastro, atualizar lista de professores disponíveis, iniciar integração com sistemas internos (futuro).
- **InstructorUpdatedEvent**:
  - **Descrição:** Publicado quando os dados de um professor são atualizados.
  - **Origem**: Instructor Context
  - **Consumidores:** Notification Context
  - **Objetivo:** Notificar sobre a atualização do professor e permitir ações relacionadas à prescrição de treinos.
  - **Possíveis Ações:** Enviar confirmação de atualização, ajustar informações de contato, atualizar registros internos (futuro).
- **InstructorDeactivatedEvent**:
  - **Descrição:** Publicado quando um professor é desativado.
  - **Origem**: Instructor Context
  - **Consumidores:** Notification Context
  - **Objetivo:** Notificar sobre a desativação do professor e permitir ações relacionadas à prescrição de treinos.
  - **Possíveis Ações:** Enviar aviso de desativação, atualizar lista de professores disponíveis, ajustar atribuições de treinos (futuro).

### 6.10 Eventos do Contexto de Treinos

- **TrainingSheetCreatedEvent**:
  - **Descrição:** Publicado quando uma nova ficha de treino é criada.
  - **Origem**: Training Context
  - **Consumidores:** Notification Context
  - **Objetivo:** Notificar sobre a criação da ficha de treino e permitir ações relacionadas à prescrição de treinos.
  - **Possíveis Ações:** Enviar confirmação de criação, atualizar histórico de treinos do aluno, iniciar acompanhamento de evolução (futuro).
- **TrainingSheetExpiredEvent**:
  - **Descrição:** Publicado quando uma ficha de treino expira.
  - **Origem**: Training Context
  - **Consumidores:** Notification Context
  - **Objetivo:** Notificar sobre a expiração da ficha de treino e permitir ações relacionadas à prescrição de treinos.
  - **Possíveis Ações:** Enviar aviso de expiração, solicitar renovação da ficha de treino, atualizar status da ficha (futuro).
- **TrainingSheetUpdatedEvent**:
  - **Descrição:** Publicado quando uma ficha de treino é atualizada.
  - **Origem**: Training Context
  - **Consumidores:** Notification Context
  - **Objetivo:** Notificar sobre a atualização da ficha de treino e permitir ações relacionadas à prescrição de treinos.
  - **Possíveis Ações:** Enviar confirmação de atualização, atualizar histórico de treinos do aluno, ajustar acompanhamento de evolução (futuro).

### 6.11 Eventos Futuros

Os eventos abaixo não fazem parte do MVP, mas já são previstos pela arquitetura.

- PaymentApprovedEvent
  - Pagamento aprovado.
- PaymentFailedEvent
  - Pagamento falhou.
- PhysicalAssessmentCompletedEvent
  - Avaliação física concluída.
- AccessGrantedEvent
  - Acesso liberado.
- AccessDeniedEvent
  - Acesso negado.
- ClassScheduledEvent
  - Aula agendada.

### 6.12 Comunicação entre Contextos

O diagrama abaixo apresenta uma visão simplificada da comunicação entre os principais módulos do GymFlow.

```text
Tenant Context
     │
     │ TenantCreatedEvent
     ▼
Notification Context
     │
     ▼
Unit Context
     │
     │ UnitCreatedEvent
     ▼
Notification Context


Student Context           Enrollment Context
     │                          │
     │ StudentRegisteredEvent   │ EnrollmentActivatedEvent
     ▼                          ▼
Notification Context   ────► Notification Context
                              │
                              ▼
                         Training Context
```

### 6.13 Diretrizes para Criação de Eventos

Para manter consistência entre os módulos, todo novo evento deverá seguir as seguintes diretrizes:

- **Deve representar um fato do negócio**
  - ✔ Matrícula ativada.
  - ❌ Usuário clicou em um botão.

---

- **Deve utilizar verbo no passado**
  - ✔ EnrollmentActivated
  - ❌ ActivateEnrollment

---

- **Deve ser imutável**
  - Após publicado, um evento nunca deverá ser alterado.

---

- **Deve conter apenas informações necessárias**
  - Os eventos não devem transportar objetos completos do domínio.

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

- **Não deve depender de infraestrutura**
  - Eventos pertecem ao domínio e não devem ter dependências de frameworks, bibliotecas ou tecnologias específicas.
  - Eles não conhecem:
    - Kafka;
    - RabbitMQ;
    - REST;
    - Banco de Dados;
    - Spring Events.
  - A tecnologia utilizada para transporte do evento é responsabilidade do módulo de infraestrutura.

### 6.14 Implementação no GymFlow

O GymFlow será desenvolvido como um Monólito Modular, porém a comunicação entre os módulos ocorrerá por meio de eventos publicados no Apache Kafka.

Embora todos os módulos façam parte da mesma aplicação, eles não deverão depender diretamente uns dos outros. Sempre que uma regra de negócio resultar em uma mudança relevante no domínio, o módulo responsável publicará um evento em um tópico do Kafka.

Os módulos interessados poderão consumir esse evento e executar suas próprias regras de negócio de forma independente.

Essa abordagem proporciona:

- baixo acoplamento entre os módulos;
- maior isolamento das responsabilidades;
- facilidade para adicionar novas funcionalidades sem alterar módulos existentes;
- possibilidade de evolução para uma arquitetura distribuída no futuro;
- experiência prática com arquitetura orientada a eventos utilizando Apache Kafka.

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

- desacoplamento entre módulos;
- comunicação assíncrona;
- facilidade para inclusão de novos consumidores;
- preparação para futuras integrações externas;
- possibilidade de evolução para microsserviços sem alterar o modelo de eventos do domínio.

## 7. Notificações

### 7.1 Visão Geral

O módulo de Notificações é responsável por informar alunos e colaboradores sobre acontecimentos relevantes do sistema.

As notificações não fazem parte das regras de negócio dos demais módulos. Em vez disso, elas são disparadas a partir de eventos publicados pelos contextos de negócio e processadas de forma assíncrona.

Essa abordagem garante que funcionalidades como envio de e-mails, mensagens ou notificações push permaneçam desacopladas das regras de negócio da aplicação.

### 7.2 Objetivos

O módulo de Notificações possui os seguintes objetivos:

- centralizar toda comunicação com os usuários;
- desacoplar notificações das regras de negócio;
- permitir diferentes canais de comunicação;
- facilitar inclusão de novos meios de envio;
- possibilitar processamento assíncrono através do Apache Kafka.

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
| TenantCreatedEvent           | Tenant     | E-mail de boas-vindas       |
| UnitCreatedEvent             | Unit       | Notificação de criação      |
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

- **E-mail:**
  - Utilizado para comunicações formais
    Exemplos:
    - matrícula criada;
    - alteração de plano;
    - cancelamento;
    - comprovantes;
    - recuperação de senha.

- **WhatsApp:**
  - Utilizado para comunicações rápidas e informais
    Exemplos:
    - aviso de inadimplência;
    - lembrete de renovação de ficha de treino;
    - mensagens promocionais.
      A integração será realizada futuramente através da API oficial do WhatsApp Business.

- **Push Notification:**
  - Utilizado para comunicações instantâneas
    Exemplos:
    - aviso de expiração de ficha de treino;
    - lembrete de aula agendada;
    - notificações de eventos especiais.
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

- a operação principal deverá permanecer concluída;
- o erro deverá ser registrado em log;
- a mensagem poderá ser reenviada posteriormente conforme a política de retentativas.

### 7.9 Extensibilidade

Novos canais de comunicação poderão ser adicionados sem necessidade de alterar os módulos de negócio.

Exemplos de futuras integrações:

- SMS;
- Microsoft Teams;
- Slack;
- Telegram;
- Discord;
- Webhooks para sistemas parceiros.

### 7.10 Responsabilidades do Módulo

O Notification Context é responsável por:

- consumir eventos publicados no Apache Kafka;
- identificar o tipo de evento recebido;
- selecionar o template correspondente;
- definir o canal de comunicação;
- realizar o envio da mensagem;
- registrar o resultado do processamento.

O módulo não é responsável por:

- validar regras de negócio;
- decidir quando um evento deve ser publicado;
- alterar dados de outros contextos.

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


## 8. APIs REST

### 8.1 Visão Geral

O GymFlow disponibilizará uma API REST para acesso às funcionalidades do sistema. A API seguirá os princípios REST, utilizando recursos, verbos HTTP e códigos de resposta padronizados. As URLs representarão recursos do domínio, evitando ações explícitas sempre que possível.

### 8.2 Convenções Gerais

**Autenticação**

Todas as APIs agora requerem autenticação e operam no contexto do Tenant.

```http
POST /api/v1/auth/login #Autenticação de usuário

# Demais endpoints são protegidos por token JWT
```

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
Content-Type: application/json
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

### 8.3 Tenant API

**Criar uma nova academia (Tenant)**

```http
POST /api/v1/tenants
```

### 8.4 Units API

**Criar uma nova unidade**

```http
POST /api/v1/units
```

**Listar unidades**

```http
GET /api/v1/units
```

**Buscar unidade por ID**

```http
GET /api/v1/units/{unitId}
```

**Filtros disponíveis:**

```http
GET /api/v1/units?name=Unidade A
GET /api/v1/units?isActive=true
GET /api/v1/units?isActive=false
```

**Atualizar dados de uma unidade**

```http
PUT /api/v1/units/{unitId}
```

**Desativar uma unidade**

```http
PATCH /api/v1/units/{unitId}/deactivate
```

### 8.5 Authentication API

**Autenticar usuário**

```http
POST /api/v1/auth/login
```

**Obter informações do usuário autenticado**

```http
GET /api/v1/auth/me
```

**Logout**

```http
POST /api/v1/auth/logout
```

**Alterar senha**

```http
POST /api/v1/auth/change-password
```

**Recuperar senha**

```http
POST /api/v1/auth/forgot-password
```

### 8.6 Students API

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

### 8.7 Enrollments API

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

### 8.8 Plans API

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

### 8.9 Benefits API

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

### 8.10 Trainings API

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

### 8.11 Professors API

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

### 8.12 Códigos HTTP

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

### 8.13 Princípios adotados

A API REST do GymFlow seguirá os seguintes princípios:

- URLs representam recursos, e não ações, sempre que possível.
- Verbos HTTP expressam a intenção da operação.
- Filtros são realizados por query parameters.
- Recursos não são removidos fisicamente quando isso viola regras do domínio.
- Operações que representam processos de negócio podem utilizar sub-recursos (/cancel, /deactivate, /change-plan) quando não se enquadram em um CRUD tradicional.
- A API deve refletir o modelo de domínio e não a estrutura do banco de dados.

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

- id UUID PRIMARY KEY

---

**Auditoria**
Todas as tabelas possuirão os seguintes campos:

| Campo      | Descrição          |
| ---------- | ------------------ |
| created_at | Data de criação    |
| updated_at | Última atualização |

Quando necessário, poderão existir campos adicionais como:

- deactivated_at
- cancelled_at
- expires_at

---

**Chaves Estrangeiras**
Os relacionamentos utilizarão chaves estrangeiras para garantir integridade referencial.

Exemplo:

- student_id
- plan_id
- professor_id

---

**Exclusão**

O GymFlow não realizará exclusão física de informações que façam parte do histórico do negócio.

Sempre que possível será utilizado o conceito de encerramento ou desativação do registro.

---

### 9.3 Entidades

**Tenant**
Representa uma academia.

- **Campos**

| Campo      | Tipo                         | Obrigatório |
| ---------- | ---------------------------- | ----------- |
| id         | UUID                         | Sim         |
| name       | VARCHAR                      | Sim         |
| legal_name | VARCHAR                      | Sim         |
| trade_name | VARCHAR                      | Sim         |
| cnpj       | VARCHAR(14)                  | Sim (Único) |
| email      | VARCHAR                      | Sim         |
| phone      | VARCHAR                      | Sim         |
| status     | VARCHAR                      | Sim         |
| address    | JSONB ou campos normalizados | Sim         |
| created_at | TIMESTAMP                    | Sim         |
| updated_at | TIMESTAMP                    | Sim         |

- **Restrições**
  - CNPJ deve ser único.
  - Uma academia nunca será removida fisicamente.

**Unit**
Representa uma unidade física da academia.

- **Campos**
| Campo      | Tipo                         | Obrigatório |
| ---------- | ---------------------------- | ----------- |
| id         | UUID                         | Sim         |
| tenant_id  | UUID                         | Sim         |
| name       | VARCHAR                      | Sim         |
| email      | VARCHAR                      | Sim         |
| phone      | VARCHAR                      | Sim         |
| address    | JSONB ou campos normalizados | Sim         |
| created_at | TIMESTAMP                    | Sim         |
| updated_at | TIMESTAMP                    | Sim         |

- **Restrições**
  - Uma unidade nunca será removida fisicamente.
  - O campo tenant_id referencia a academia à qual a unidade pertence.

**User**
Representa um usuário do sistema, que pode ser um recepcionista, professor ou administrador.

- **Campos**
| Campo      | Tipo      | Obrigatório |
| ---------- | --------- | ----------- |
| id         | UUID      | Sim         |
| tenant_id  | UUID      | Sim         |
| unit_id    | UUID      | Sim         |
| full_name  | VARCHAR   | Sim         |
| email      | VARCHAR   | Sim (Único) |
| password   | VARCHAR   | Sim         |
| role       | VARCHAR   | Sim         |
| status     | VARCHAR   | Sim         |
| created_at | TIMESTAMP | Sim         |
| updated_at | TIMESTAMP | Sim         |

- **Restrições**
  - Email deve ser único.
  - O campo tenant_id referencia a academia à qual o usuário pertence.
  - O campo unit_id referencia a unidade à qual o usuário está associado.

**Student**
Representa o cadastro permanente de um aluno.

- **Campos**

| Campo      | Tipo                         | Obrigatório |
| ---------- | ---------------------------- | ----------- |
| id         | UUID                         | Sim         |
| tenant_id  | UUID                         | Sim         |
| unit_id    | UUID                         | Sim         |
| full_name  | VARCHAR                      | Sim         |
| cpf        | VARCHAR(11)                  | Sim (Único) |
| birth_date | DATE                         | Sim         |
| gender     | VARCHAR                      | Sim         |
| email      | VARCHAR                      | Sim         |
| phone      | VARCHAR                      | Sim         |
| address    | JSONB ou campos normalizados | Sim         |
| created_at | TIMESTAMP                    | Sim         |
| updated_at | TIMESTAMP                    | Sim         |

- **Restrições**
  - CPF deve ser único.
  - O aluno nunca será removido fisicamente.

---

**Plan**

Representa um plano comercializado pela academia.

- **Campos**

| Campo       | Tipo      |
| ----------- | --------- |
| id          | UUID      |
| tenant_id   | UUID      |
| unit_id     | UUID      |
| name        | VARCHAR   |
| description | TEXT      |
| periodicity | ENUM      |
| price       | DECIMAL   |
| active      | BOOLEAN   |
| created_at  | TIMESTAMP |
| updated_at  | TIMESTAMP |

---

**Benefit**

Representa um benefício que pode ser associado a diferentes planos.

- **Campos**

| Campo       | Tipo      |
| ----------- | --------- |
| id          | UUID      |
| tenant_id   | UUID      |
| unit_id     | UUID      |
| name        | VARCHAR   |
| description | TEXT      |
| active      | BOOLEAN   |
| created_at  | TIMESTAMP |
| updated_at  | TIMESTAMP |

---

**Plan_Benefit**

Tabela responsável pela associação entre planos e benefícios.

- **Campos**

| Campo      | Tipo |
| ---------- | ---- |
| plan_id    | UUID |
| benefit_id | UUID |

- **Observações**
  - Um plano pode possuir vários benefícios.
  - Um benefício pode pertencer a vários planos.

---

**Enrollment**

Representa o vínculo entre um aluno e um plano.

- **Campos**

| Campo      | Tipo      |
| ---------- | --------- |
| id         | UUID      |
| tenant_id  | UUID      |
| unit_id    | UUID      |
| student_id | UUID      |
| plan_id    | UUID      |
| status     | VARCHAR   |
| start_date | DATE      |
| end_date   | DATE      |
| due_day    | SMALLINT  |
| created_at | TIMESTAMP |
| updated_at | TIMESTAMP |

- **Restrições**
  - Apenas uma matrícula ativa por aluno.
  - Mudança de plano gera uma nova matrícula.

---

**Professor**

Representa um professor da academia.

- **Campos**

| Campo      | Tipo      |
| ---------- | --------- |
| id         | UUID      |
| tenant_id  | UUID      |
| unit_id    | UUID      |
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

- **Campos**

| Campo                 | Tipo      |
| --------------------- | --------- |
| id                    | UUID      |
| tenant_id             | UUID      |
| name                  | VARCHAR   |
| muscle_group          | VARCHAR   |
| execution_description | TEXT      |
| video_url             | VARCHAR   |
| created_at            | TIMESTAMP |
| updated_at            | TIMESTAMP |

- **Observações**
  - Não armazena séries, repetições ou carga.

---

**Training_Sheet**

Representa uma ficha de treino.

- **Campos**

| Campo           | Tipo      |
| --------------- | --------- |
| id              | UUID      |
| tenant_id       | UUID      |
| unit_id         | UUID      |
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

- **Campos**

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

- **Observações**
  - Um mesmo exercício poderá aparecer em diversas fichas, com parâmetros diferentes.

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

- CPF único para cada aluno.
- Integridade referencial entre todas as entidades.
- Não permitir matrículas sem aluno.
- Não permitir matrículas sem plano.
- Não permitir fichas sem professor responsável.
- Não permitir exercícios prescritos sem ficha de treino.
- Não permitir benefícios associados a planos inexistentes.

As regras de negócio mais complexas continuarão sendo validadas pela camada de domínio.

---

### 9.6 Estratégia de Persistência

A persistência do GymFlow seguirá as seguintes diretrizes:

- PostgreSQL como banco de dados relacional.
- Flyway para versionamento do esquema.
- Cada Tenant terá seu próprio schema no banco de dados.
- A escolha do schema é feita dinamicamente no momento da autenticação, com base no tenantId do usuário.
- O Flyway será executado para cada novo Tenant criado, aplicando o schema base.
- Spring Data JPA como mecanismo de persistência.
- UUID como chave primária.
- Índices criados para consultas frequentes.
- Constraints para garantir integridade referencial.

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

### 10.1 Visão Geral

O desenvolvimento do GymFlow será realizado de forma incremental, priorizando a entrega contínua de funcionalidades de maior valor para o negócio.

Cada fase representa uma evolução do produto, permitindo validar regras de negócio, consolidar a arquitetura e incorporar novas tecnologias sem comprometer a estabilidade da aplicação.

O roadmap apresentado neste documento representa o planejamento de evolução previsto para o projeto e poderá ser revisado conforme novas necessidades surgirem.

### 10.2 MVP - Gestão de Academias (SaaS)

O MVP concentra as funcionalidades essenciais para operação de uma academia.

- Objetivos
- Estrutura multi-tenant.
- Cadastro de academias (Tenants).
- Cadastro de unidades.
- Cadastro de usuários.
- Cadastro de alunos.
- Cadastro de professores.
- Cadastro de planos.
- Cadastro de benefícios.
- Controle de matrículas.
- Alteração de planos.
- Controle de inadimplência.
- Catálogo de exercícios.
- Criação de fichas de treino.
- Autenticação e autorização de usuários.
- Histórico de fichas de treino.
- API REST.
- Publicação de eventos utilizando Apache Kafka.
- Envio de notificações por e-mail.

Ao final desta fase, o GymFlow será capaz de atender às principais necessidades operacionais de uma academia de pequeno porte.

### 10.3 Fase 2 - Operação da Academia

Após a conclusão do MVP, o sistema será expandido para oferecer funcionalidades voltadas ao dia a dia da academia.

**Funcionalidades previstas:**

- Controle de avaliações físicas.
- Histórico de avaliações.
- Upload de fotos para acompanhamento da evolução.
- Agenda de aulas.
- Agenda de professores.
- Agenda de alunos.
- Registro de presença.
- Dashboard operacional.

### 10.4 Fase 3 - Financeiro

Nesta etapa serão incorporadas funcionalidades relacionadas ao gerenciamento financeiro.

**Funcionalidades previstas:**

- Integração com gateways de pagamento.
- Cobrança recorrente.
- Controle financeiro.
- Fluxo de caixa.
- Emissão de recibos.
- Relatórios financeiros.
- Controle de descontos.
- Controle de bolsas e convênios.

### 10.5 Fase 4 - Aplicativo do Aluno

O foco desta etapa será disponibilizar funcionalidades diretamente aos alunos.

**Funcionalidades previstas:**

- Aplicativo móvel.
- Consulta de treinos.
- Histórico de treinos.
- Notificações push.
- Consulta de matrícula.
- Renovação de plano.
- Download de comprovantes.
- Perfil do aluno.

### 10.6 Fase 5 - Integrações

O GymFlow será preparado para integração com serviços externos.

**Funcionalidades previstas:**

- Integração com catracas.
- Integração com WhatsApp Business.
- Webhooks.
- API pública.
- Integração com sistemas de pagamento.
- Integração com plataformas de BI.

### 10.7 Evolução Arquitetural

Além da evolução funcional, o projeto também seguirá uma evolução arquitetural.

#### Etapa 1

- Monólito Modular.
- Spring Modulith.
- PostgreSQL.
- Flyway.
- Apache Kafka.
- Docker.

---

#### Etapa 2

- Observabilidade.
- Logs centralizados.
- Métricas.
- Monitoramento.
- Tracing distribuído.

---

#### Etapa 3

- Cache distribuído.
- Balanceamento de carga.
- Escalabilidade horizontal.
- Deploy automatizado.

---

#### Etapa 4

- Avaliação da extração de módulos específicos para microsserviços, caso existam requisitos de escalabilidade ou independência operacional que justifiquem essa mudança arquitetural.

### 10.8 Evolução Tecnológica

Durante o desenvolvimento do projeto serão incorporadas tecnologias com o objetivo de ampliar a qualidade da aplicação e consolidar conhecimentos em engenharia de software.

**Tecnologias previstas:**

- Spring Boot
- Spring Modulith
- Spring Security
- Spring Data JPA
- PostgreSQL
- Flyway
- Apache Kafka
- Docker
- Testcontainers
- JUnit 5
- Mockito
- MapStruct
- Bean Validation
- OpenAPI
- GitHub Actions
- Prometheus
- Grafana
- Loki
- Tempo
- Kubernetes (estudo futuro)

A adoção dessas tecnologias ocorrerá de forma gradual, respeitando a evolução natural do projeto.

### 10.9 Critérios de Conclusão

Uma fase será considerada concluída quando atender aos seguintes critérios:

- Funcionalidades implementadas.
- Testes automatizados aprovados.
- Documentação atualizada.
- APIs documentadas.
- Migrações do banco versionadas.
- Cobertura mínima de testes definida para o projeto.
- Revisão arquitetural realizada.

### 10.10 Visão de Longo Prazo

O GymFlow tem como objetivo evoluir de um projeto de estudo para uma aplicação completa de gestão de academias, construída com práticas modernas de Engenharia de Software.

Além de atender às necessidades do domínio, o projeto servirá como laboratório para aplicação de conceitos como:

- Domain-Driven Design (DDD)
- Arquitetura Hexagonal
- Arquitetura Orientada a Eventos
- Spring Modulith
- Apache Kafka
- Integração Contínua (CI)
- Entrega Contínua (CD)
- Observabilidade
- Testes Automatizados
- Boas práticas de desenvolvimento Java

O roadmap apresentado neste documento orienta essa evolução, mantendo alinhamento entre objetivos de negócio, arquitetura e aprendizado contínuo.
