# ADR-005 - Modularização por Contextos de Negócio

## Status: Ativo

## Data: 09/07/2026

## Última atualização: 09/07/2026

## Contexto

Após definir o Domain-Driven Design (DDD) como abordagem para modelagem do GymFlow, tornou-se necessário estabelecer como o domínio seria dividido dentro da aplicação.

O sistema possui diferentes áreas de responsabilidade, cada uma com regras de negócio próprias, ciclo de vida independente e necessidades específicas de evolução.

Organizar o projeto apenas por camadas técnicas (Controller, Service e Repository) faria com que funcionalidades relacionadas ao mesmo domínio ficassem distribuídas em diferentes partes do código, aumentando o acoplamento e dificultando sua manutenção.

Diante desse cenário, optou-se por estruturar o sistema utilizando Contextos de Negócio (Bounded Contexts), onde cada contexto representa uma área específica do domínio da aplicação.

## Decisão

O GymFlow será organizado em módulos independentes, cada um representando um Contexto de Negócio.

Cada módulo será responsável por encapsular suas próprias regras de negócio, casos de uso, interfaces, implementações de infraestrutura e APIs públicas.

A divisão inicial dos contextos será composta pelos seguintes módulos:

- Student
- Enrollment
- Plan
- Training
- Notification

Além desses, alguns contextos poderão ser adicionados futuramente conforme a evolução do produto, como:

- Identity
- Billing
- Assessment
- Scheduling
- Analytics

Cada contexto será considerado proprietário dos dados e das regras relacionadas ao seu domínio.

## Motivação

A modularização por Contextos de Negócio foi adotada pelos seguintes motivos:

- Organizar o projeto utilizando a linguagem do domínio.
- Reduzir o acoplamento entre funcionalidades distintas.
- Facilitar a evolução independente de cada contexto.
- Permitir que cada módulo evolua de acordo com suas necessidades específicas.
- Tornar a arquitetura mais aderente aos princípios do Domain-Driven Design.
- Facilitar a navegação e compreensão do código.

Além dos benefícios técnicos, essa abordagem proporciona uma experiência prática na construção de aplicações modulares alinhadas às arquiteturas utilizadas em sistemas corporativos.

## Diretrizes

Cada Contexto de Negócio deverá possuir responsabilidade exclusiva sobre seu domínio.

Isso significa que:

- Cada módulo será responsável por suas próprias regras de negócio.
- Cada módulo implementará seus próprios casos de uso.
- Cada módulo poderá possuir sua própria estratégia de persistência.
- Cada módulo poderá publicar eventos relacionados ao seu domínio.
- Cada módulo deverá expor apenas os contratos necessários para comunicação com outros contextos.

O acesso direto às implementações internas de outro módulo deverá ser evitado.

Sempre que possível, a comunicação entre contextos ocorrerá por meio de eventos de domínio ou contratos explicitamente definidos.

## Consequências

### Positivas

- Alta coesão dentro de cada módulo.
- Baixo acoplamento entre contextos.
- Melhor organização do código.
- Facilidade para manutenção e evolução do sistema.
- Possibilidade de evolução tecnológica independente entre módulos.
- Maior aderência aos princípios do DDD e da Arquitetura Hexagonal.

### Negativas

- Necessidade de definir claramente os limites de cada contexto.
- Maior atenção ao gerenciamento das dependências entre módulos.
- Comunicação entre módulos exige maior planejamento quando comparada ao acesso direto entre classes.

## Alternativas Consideradas

### Modularização por Camadas Técnicas

Foi considerada a organização tradicional baseada em camadas como Controller, Service, Repository e Entity.

Essa abordagem foi descartada por dispersar funcionalidades do mesmo domínio em diferentes partes do projeto, dificultando sua evolução.

### Modularização por Tecnologias

Também foi considerada uma divisão baseada em responsabilidades técnicas, como módulos específicos para banco de dados, mensageria ou APIs.

Embora essa organização seja útil para componentes de infraestrutura compartilhados, ela não representa adequadamente o domínio da aplicação e tende a concentrar regras de negócio fora de seus respectivos contextos.

Como exceção, o GymFlow poderá possuir módulos técnicos de infraestrutura compartilhada, como persistência, mensageria, segurança e observabilidade. Esses módulos não conterão regras de negócio e existirão exclusivamente para fornecer capacidades técnicas aos Contextos de Negócio.

## Revisão Futura

Novos Contextos de Negócio poderão ser adicionados conforme o GymFlow evoluir.

A criação de novos módulos deverá ocorrer sempre que um conjunto de funcionalidades representar um domínio suficientemente independente, com regras próprias e baixo acoplamento em relação aos demais contextos.

A modularização deverá continuar refletindo o domínio do negócio, evitando reorganizações motivadas apenas por aspectos técnicos ou estruturais.

## Observação

> Os Contextos de Negócio representam também a estratégia de modularização física do projeto. Cada contexto será implementado como um módulo Gradle independente, preservando encapsulamento, isolamento de responsabilidades e baixo acoplamento entre as diferentes áreas do sistema
