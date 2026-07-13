# Arquitetura Multi-Tenant

> **Localização:** `docs/architecture/Multi-Tenant.md`
>
> **Relacionamento**
> - ADR-006 - Estratégia de Multi-Tenant
> - ADR-007 — Adoção do PostgreSQL como Sistema Gerenciador de Banco de Dados
> - ADR-008 — Versionamento do Banco de Dados com Flyway
>
> **Status:** Em evolução
>
> Este documento descreve a arquitetura técnica da solução Multi-Tenant adotada pelo GymFlow. Seu conteúdo será refinado conforme novas decisões forem tomadas e a implementação evoluir.

## 1. Objetivo

Este documento tem como objetivo descrever a arquitetura técnica responsável pela implementação da estratégia de Multi-Tenant adotada pelo GymFlow.

Enquanto os ADRs registram as decisões arquiteturais relacionadas à escolha da estratégia de isolamento de dados, do banco de dados e do mecanismo de versionamento das estruturas de persistência, este documento detalha como essas decisões serão aplicadas na implementação da solução.

A arquitetura Multi-Tenant é um dos pilares do GymFlow, pois permite que uma única instância da aplicação atenda múltiplas academias (Tenants), garantindo isolamento lógico dos dados, simplicidade operacional e possibilidade de evolução para um ambiente SaaS.

Ao longo deste documento serão apresentados:
  - os conceitos envolvidos na arquitetura Multi-Tenant;
  - os componentes responsáveis pelo gerenciamento dos Tenants;
  - o fluxo completo de uma requisição até o acesso ao banco de dados;
  - a organização dos schemas no PostgreSQL;
  - a estratégia de versionamento utilizando Flyway;
  - aspectos relacionados à segurança, testes e evolução da arquitetura.

Este documento deverá ser atualizado sempre que novas decisões de implementação forem incorporadas ao projeto, servindo como referência técnica para o desenvolvimento e manutenção do GymFlow.

## 2. Conceitos

Antes de detalhar a implementação da arquitetura Multi-Tenant, é importante compreender alguns conceitos fundamentais utilizados ao longo deste documento.

### 2.1 SaaS (Software as a Service)

O GymFlow foi concebido como uma aplicação SaaS (*Software as a Service*).

Nesse modelo, uma única aplicação é utilizada por diversos clientes, cada um consumindo o sistema de forma independente.

No contexto do GymFlow, cada academia representa um cliente da plataforma.

Embora todos utilizem a mesma aplicação, cada academia possui seus próprios dados e regras de operação.

---

### 2.2 Tenant

Um **Tenant** representa um cliente da plataforma.

No GymFlow, um Tenant corresponde a uma academia cadastrada no sistema.

Cada Tenant possui seu próprio conjunto de informações, incluindo:

* alunos;
* professores;
* planos;
* matrículas;
* fichas de treino;
* benefícios;
* notificações;
* demais dados relacionados ao seu negócio.

Os dados pertencentes a um Tenant nunca devem ser acessíveis por outro Tenant.

---

### 2.3 Multi-Tenant

Multi-Tenant é um modelo arquitetural no qual uma única instância da aplicação atende múltiplos clientes de forma simultânea.

Embora todos compartilhem a mesma aplicação, cada Tenant deve perceber o sistema como se fosse exclusivo para sua organização.

O principal desafio desse modelo consiste em garantir o isolamento entre os dados pertencentes a cada cliente.

---

### 2.4 Estratégias de Multi-Tenant

Existem diferentes estratégias para implementação de aplicações Multi-Tenant.

As mais comuns são:

#### Banco de Dados por Tenant

Cada cliente possui seu próprio banco de dados.

Essa abordagem oferece o maior nível de isolamento, porém aumenta significativamente o custo operacional e a complexidade de gerenciamento.

#### Schema por Tenant

Todos os clientes compartilham a mesma instância do banco de dados, porém cada Tenant possui um schema exclusivo.

Essa estratégia oferece um excelente equilíbrio entre isolamento, simplicidade operacional e escalabilidade, sendo a abordagem adotada pelo GymFlow.

#### Banco Compartilhado (Shared Database)

Todos os clientes compartilham as mesmas tabelas.

Os registros são diferenciados por uma coluna identificadora do Tenant.

Embora seja uma solução simples de implementar, exige maior cuidado durante o desenvolvimento para evitar vazamento de dados entre clientes.

---

### 2.5 Schema

Um **schema** pode ser entendido como um agrupador lógico de objetos dentro de um banco de dados.

No PostgreSQL, um schema pode conter tabelas, índices, sequências, views e demais objetos de persistência.

No GymFlow, cada Tenant possuirá um schema exclusivo, contendo todas as estruturas necessárias para seu funcionamento.

Essa abordagem permite isolar logicamente os dados sem a necessidade de criar um banco de dados independente para cada academia.

---

### 2.6 Isolamento de Dados

O isolamento de dados garante que todas as operações realizadas por um Tenant ocorram exclusivamente sobre seu próprio conjunto de informações.

Esse isolamento é um requisito fundamental da arquitetura do GymFlow e deverá ser transparente para os módulos de negócio.

Toda a responsabilidade pelo gerenciamento do Tenant ficará concentrada na camada de infraestrutura.

---

### 2.7 Infraestrutura Transparente

As regras de negócio do GymFlow não possuem conhecimento sobre a estratégia de Multi-Tenant adotada.

Entidades, casos de uso e serviços de domínio trabalham apenas com conceitos do negócio.

A identificação do Tenant, a seleção do schema correto e a configuração da conexão com o banco de dados são responsabilidades exclusivas da infraestrutura da aplicação.

Essa decisão mantém o domínio desacoplado dos detalhes técnicos de persistência e está alinhada aos princípios definidos nos ADRs de Arquitetura Hexagonal e Independência do Domínio.


