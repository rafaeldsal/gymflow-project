# ADR-004 — Adoção de Domain-Driven Design (DDD)

## Status: Aceito

## Data: 09/07/2026

## Última Atualização: 09/07/2026

## Contexto

O principal objetivo do GymFlow é desenvolver uma solução SaaS para gestão de academias mantendo o domínio do negócio como o elemento central da aplicação.

Além de atender às necessidades funcionais do sistema, o projeto também possui caráter educacional, buscando aprofundar conhecimentos em modelagem de domínio e Arquitetura de Software.

Durante o levantamento dos requisitos foi identificado que o domínio da aplicação possui regras de negócio que vão além de operações básicas de CRUD, como controle de matrículas, alteração de planos, gerenciamento de benefícios, criação de fichas de treino e comunicação entre diferentes partes do sistema por meio de eventos.

Diante desse cenário, tornou-se necessário adotar uma abordagem que priorizasse a compreensão do negócio antes da implementação técnica.

## Decisão

Foi adotado o Domain-Driven Design (DDD) como abordagem para modelagem do domínio do GymFlow.

As decisões de implementação deverão partir da compreensão do negócio e não das tecnologias utilizadas.

O domínio será representado por conceitos reais da academia, utilizando entidades, agregados, value objects, serviços de domínio e eventos de domínio sempre que fizer sentido.

A organização dos módulos da aplicação seguirá os contextos identificados durante a modelagem do domínio.

## Motivação

A adoção do Domain-Driven Design foi motivada pelos seguintes fatores:

- Compreender profundamente o domínio antes de iniciar a implementação.
- Modelar o software utilizando a linguagem do negócio.
- Reduzir a distância entre regras de negócio e código.
- Organizar o sistema em contextos independentes.
- Facilitar a evolução do domínio à medida que novas funcionalidades forem adicionadas.
- Consolidar conhecimentos em DDD por meio de um projeto real.

Além dos benefícios técnicos, esta decisão está alinhada ao objetivo de utilizar o GymFlow como laboratório para estudo de modelagem de domínio em aplicações Java.

## Diretrizes

Como consequência desta decisão, o desenvolvimento deverá seguir algumas diretrizes.

### O domínio será composto por:

- Entidades.
- Value Objects.
- Agregados.
- Serviços de Domínio.
- Eventos de Domínio.
- Repositórios definidos como Ports.

### A modelagem deverá priorizar:

- Regras de negócio antes da persistência.
- Linguagem ubíqua.
- Baixo acoplamento entre contextos.
- Alta coesão dentro de cada módulo.

### O domínio não deverá ser modelado a partir de:

- Estrutura das tabelas do banco de dados.
- Endpoints da API REST.
- Frameworks utilizados pela aplicação.
- Limitações da camada de infraestrutura.

## Consequências

### Positivas

- Código mais próximo das regras de negócio.
- Melhor organização dos contextos da aplicação.
- Facilidade para evolução do domínio.
- Comunicação mais clara entre documentação e implementação.
- Maior aderência à Arquitetura Hexagonal.

### Negativas

- Curva de aprendizado superior em relação a arquiteturas tradicionais.
- Necessidade de maior tempo na fase de modelagem.
- Maior disciplina para preservar a linguagem do domínio durante a evolução do projeto.

## Alternativas Consideradas

### Modelagem orientada ao banco de dados

Foi considerada a modelagem inicial a partir da estrutura relacional.

Essa abordagem foi descartada por direcionar o desenvolvimento para aspectos técnicos em vez das regras de negócio.

### Modelagem orientada à API

Também foi considerada uma abordagem baseada nos recursos expostos pela API REST.

Essa alternativa foi descartada por favorecer modelos anêmicos e por limitar a evolução do domínio às necessidades da interface de comunicação.

## Revisão Futura

A adoção do Domain-Driven Design deverá permanecer como princípio orientador durante toda a evolução do GymFlow.

Novos módulos, tecnologias e integrações deverão respeitar a linguagem do domínio e os limites dos contextos estabelecidos, preservando a consistência do modelo de negócio ao longo do tempo.
