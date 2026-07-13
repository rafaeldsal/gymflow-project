# ADR-003 - Independência do Domínio em relação às Tecnologias

## Status: Aceito

## Data: 09/07/2026

## Última Atualização: 09/07/2026

## Contexto

Após definir a Arquitetura Hexagonal como padrão arquitetural do GymFlow, tornou-se necessário estabelecer uma diretriz para evitar que as regras de negócio fossem acopladas às tecnologias utilizadas pela aplicação.

Como o projeto tem como objetivo evoluir continuamente ao longo do tempo, é esperado que novas tecnologias sejam incorporadas durante seu ciclo de vida, como diferentes bancos de dados, mecanismos de mensageria, ferramentas de observabilidade ou até mesmo novos frameworks.

Nesse cenário, permitir que o domínio conheça detalhes dessas tecnologias aumentaria o acoplamento e dificultaria futuras evoluções.

## Decisão

As regras de negócio do GymFlow serão completamente independentes de frameworks e tecnologias externas.

O domínio conhecerá apenas conceitos do próprio negócio e contratos (Ports) definidos pela aplicação.

Qualquer interação com recursos externos deverá ocorrer por meio de interfaces implementadas por Adapters na camada de infraestrutura.

O domínio não poderá depender diretamente de bibliotecas como Spring Framework, Spring Data JPA, Apache Kafka, PostgreSQL, Redis ou qualquer outra tecnologia específica.

## Motivação

Esta decisão foi tomada para garantir que o domínio permaneça como o núcleo da aplicação, representando exclusivamente as regras de negócio.

Além dos benefícios arquiteturais, essa abordagem permite utilizar o GymFlow como ambiente de estudo para compreender como aplicações corporativas conseguem evoluir tecnologicamente preservando suas regras de negócio.

Ao manter o domínio isolado, torna-se possível alterar tecnologias de infraestrutura sem que seja necessário modificar a lógica do sistema.

## Diretrizes

Como consequência desta decisão, algumas regras deverão ser respeitadas durante o desenvolvimento.

### O domínio não deverá conter:

- Anotações do Spring Framework (@Service, @Component, @Repository, entre outras).
- Dependências do Spring Data JPA.
- Uso de EntityManager.
- Uso de JdbcTemplate.
- Uso de KafkaTemplate.
- Dependências de bancos de dados específicos.
- Dependências de bibliotecas de mensageria.
- Dependências relacionadas à camada Web.

### O domínio poderá conter:

- Entidades de domínio.
- Value Objects.
- Agregados.
- Serviços de domínio.
- Eventos de domínio.
- Interfaces (Ports).
- Regras de negócio.

## Consequências

### Positivas

- Regras de negócio independentes de tecnologias.
- Facilidade para testes unitários.
- Maior capacidade de evolução da infraestrutura.
- Menor acoplamento entre domínio e framework.
- Código mais alinhado aos princípios da Arquitetura Hexagonal.

### Negativas

- Maior quantidade de interfaces e classes de adaptação.
- Necessidade de disciplina para evitar violações arquiteturais.
- Curva de aprendizado superior quando comparada a arquiteturas tradicionais.

## Alternativas Consideradas

### Acoplamento direto ao Spring Framework

Foi considerada a utilização direta das abstrações fornecidas pelo ecossistema Spring.

Embora essa abordagem reduza a quantidade inicial de código, ela aumenta o acoplamento entre o domínio e a infraestrutura, dificultando futuras mudanças tecnológicas.

### Acoplamento direto à persistência

Também foi considerada a utilização direta de entidades JPA e repositórios do Spring Data como modelo de domínio.

Essa abordagem foi descartada por misturar conceitos de negócio com detalhes de persistência.

## Revisão Futura

Esta decisão deverá permanecer válida independentemente das tecnologias adotadas pelo GymFlow.

Caso novos mecanismos de persistência, mensageria ou integração sejam incorporados ao projeto, eles deverão ser adicionados por meio de novos Adapters, preservando a independência do domínio.