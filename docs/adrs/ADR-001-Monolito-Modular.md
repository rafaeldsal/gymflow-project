# ADR-001 - Adoção de Arquitetura Monólito Modular

## Status: Aceito

## Data: 09/07/2026

## Última Atualização: 09/07/2026

## Contexto

O GymFlow é um projeto desenvolvido com dois objetivos principais:

- Construir uma solução SaaS (Software as a Service) para gestão de academias.
- Servir como projeto de estudo para aprofundar conhecimentos em Arquitetura de Software, Domain Driven Design (DDD), Arquitetura Hexagonal e boas práticas de desenvolvimento no ecossistema Java.

Embora o projeto tenha potencial para evoluir comercialmente, seu foco inicial é validar regras de negócio, construir um domínio consistente e adquirir experiência prática com arquiteturas amplamente utilizadas no mercado.

Diante desse cenário, foi necessário definir uma arquitetura que permitisse organizar o sistema de forma modular, facilitando sua evolução ao longo do tempo, sem introduzir complexidade operacional inerente a uma arquitetura distribuída.

## Decisão

Foi adotada uma arquitetura de Monólito Modular.

A aplicação será executada como um único processo, porém organizada em módulos independentes, alinhados aos contextos de negócio identificados durante a modelagem do domínio.

Cada módulo será responsável por suas próprias regras de negócio, casos de uso, interfaces e implementações de infraestrutura, mantendo baixo acoplamento e alta coesão.

A comunicação entre módulos deverá ocorrer por meio de contratos bem definidos e, sempre que possível, utilizando eventos de domínio para reduzir dependências diretas.

## Motivação

A adoção de um Monólito Modular foi motivada pelos seguintes fatores:

- Permitir a aplicação prática de conceitos de Domain-Driven Design.
- Organizar o sistema por contexto de negócio, evitando a tradicional divisão por camadas técnicas.
- Facilitar a manutenção e evolução do código à medida que novas funcionalidades forem incorporadas.
- Construir uma arquitetura próxima das encontradas em aplicações Java corporativas.
- Aprender a desenvolver, testar e evoluir um Monólito Modular antes de considerar uma arquitetura baseada em microsserviços.
- Evitar a complexidade operacional de um ambiente distribuído enquanto o produto ainda está em fase de evolução.

Além dos aspectos técnicos, esta decisão está diretamente alinhada ao objetivo de utilizar o GymFlow como laboratório para estudo de Arquitetura de Software, permitindo compreender na prática os desafios e benefícios desse estilo arquitetural.

## Consequências

### Positivas

- Separação clara entre os diferentes contextos de negócio.
- Evolução independente dos módulos.
- Facilidade para aplicação de DDD e Arquitetura Hexagonal.
- Menor complexidade operacional quando comparado a uma arquitetura de microsserviços.
- Facilidade para testes locais, depuração e desenvolvimento.
- Possibilidade de adoção futura de ferramentas como Spring Modulith para validação arquitetural.

### Negativas

- Todos os módulos compartilham o mesmo processo de execução.
- É necessário manter disciplina arquitetural para evitar dependências indevidas entre módulos.
- A escalabilidade ocorre inicialmente sobre a aplicação como um todo, e não sobre módulos específicos.

## Alternativas Consideradas

### Monólito Tradicional

Foi descartado por favorecer o acoplamento entre funcionalidades e dificultar a evolução do domínio à medida que o sistema cresce.

### Microsserviços

Embora seja uma arquitetura amplamente utilizada em sistemas distribuídos, sua adoção foi considerada prematura para o estágio atual do GymFlow.

Além da maior complexidade de infraestrutura, observabilidade, comunicação entre serviços e deploy, a utilização de microsserviços neste momento agregaria desafios que não contribuem diretamente para os objetivos do projeto.

A decisão foi priorizar uma arquitetura mais simples de operar, mantendo a possibilidade de evolução futura caso surjam requisitos que justifiquem essa mudança.

## Revisão Futura

Esta decisão poderá ser revisada caso o GymFlow apresente requisitos que demandem escalabilidade independente entre módulos, múltiplas equipes de desenvolvimento ou restrições técnicas que justifiquem a adoção de uma arquitetura distribuída.

Até que esses fatores existam, o Monólito Modular permanece como a arquitetura que melhor equilibra simplicidade, organização e potencial de evolução.
