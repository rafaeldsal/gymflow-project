# Arquitetura Monólito Modular

> **Localização:** `docs/architecture/Monolito-Modular.md`

## Objetivo

Este documento descreve como a arquitetura Monólito Modular é implementada no GymFlow.

Enquanto o ADR-001 registra a decisão de adotar esse estilo arquitetural, este documento apresenta sua implementação prática, incluindo organização física do projeto, responsabilidades dos módulos, regras de comunicação e diretrizes para evolução da aplicação.

## Visão Geral

O GymFlow é executado como uma única aplicação Spring Boot.

Todo o sistema é iniciado em um único processo Java, compartilhando a mesma JVM, o mesmo ciclo de vida da aplicação e a mesma infraestrutura de execução.

Apesar disso, o código-fonte é organizado em módulos independentes, representando os diferentes contextos de negócio da aplicação.

Cada módulo possui autonomia para implementar suas próprias regras de negócio, mantendo baixo acoplamento em relação aos demais módulos.

## Objetivos da Arquitetura

A arquitetura foi projetada para atender aos seguintes objetivos:

- Organizar o sistema por Contextos de Negócio.
- Facilitar a evolução da aplicação.
- Reduzir o acoplamento entre funcionalidades.
- Aumentar a coesão dos módulos.
- Facilitar testes.
- Permitir evolução futura para uma arquitetura distribuída, caso necessário.

## Organização Física

Cada Contexto de Negócio será implementado como um módulo Gradle independente.

A estrutura inicial do projeto será semelhante à seguinte:

```plaintext
gymflow/
├── gymflow-bootstrap
├── gymflow-shared
├── gymflow-student
├── gymflow-enrollment
├── gymflow-plan
├── gymflow-training
├── gymflow-notification
├── gymflow-infrastructure
└── build.gradle
```

Cada módulo possui responsabilidade exclusiva sobre seu domínio.

## Responsabilidades dos Módulos

Os módulos representam os Contextos de Negócio identificados durante a modelagem do domínio.

Como regra geral:

- Cada módulo possui seu próprio domínio;
- Seus próprios casos de uso;
- Suas próprias portas (Ports);
- Seus próprios adaptadores (Adapters);
- Sua própria persistência;
- Seus próprios eventos.

Não existe um módulo responsável por toda a lógica de negócio da aplicação.

## Comunicação entre Módulos

Os módulos não devem acessar diretamente implementações internas de outros módulos.

A comunicação poderá ocorrer por dois mecanismos.

### Comunicação síncrona

Quando um módulo necessitar consultar outro módulo durante a execução de um caso de uso, a interação deverá ocorrer por meio de contratos públicos (Ports).

Essa comunicação deve ser utilizada apenas quando houver dependência imediata da resposta.

### Comunicação assíncrona

Sempre que possível, alterações relevantes no domínio deverão gerar Eventos de Domínio.

Esses eventos poderão ser publicados para outros módulos utilizando a infraestrutura de mensageria da aplicação.

Essa abordagem reduz o acoplamento entre Contextos de Negócio e favorece a evolução independente dos módulos.

## Dependências entre Módulos

A criação de dependências diretas entre módulos deve ser evitada.

Um módulo somente poderá depender de outro quando essa dependência representar uma relação clara do domínio.

Dependências circulares são proibidas.

Sempre que possível, módulos deverão se comunicar por contratos ou eventos.

## Compartilhamento de código

Componentes reutilizáveis poderão ser centralizados em módulos compartilhados.

Exemplos:

- Configuração da aplicação;
- Segurança;
- Observabilidade;
- Mensageria;
- Persistência;
- Classes utilitárias;
- Abstrações comuns.

Esses módulos não deverão conter regras de negócio.

## Estrutura de Inicialização

O GymFlow possuirá um módulo responsável apenas pela inicialização da aplicação.

Esse módulo terá como responsabilidades:

- Iniciar o Spring Boot;
- Registrar configurações globais;
- Realizar o bootstrap da aplicação;
- Importar os módulos de negócio.

Nenhuma regra de negócio deverá ser implementada nesse módulo.

## Evolução da Arquitetura

A arquitetura foi concebida para permitir evolução incremental.

Novos Contextos de Negócio poderão ser adicionados sem necessidade de alterar os módulos existentes.

Da mesma forma, tecnologias de infraestrutura poderão ser substituídas preservando a organização arquitetural definida para a aplicação.

## Relação com Outros Documentos

Esta documentação complementa os seguintes artefatos:

- `docs/architecture-decisions/ADR-001-Monolito-Modular.md`
- `docs/architecture-decisions/ADR-002-Arquitetura-Hexagonal.md`
- `docs/architecture-decisions/ADR-005-Modularizacao-por-Contextos-de-Negocio.md`

Esses documentos registram as decisões arquiteturais que fundamentam a implementação descrita neste guia.
