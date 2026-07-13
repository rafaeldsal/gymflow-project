# ADR-002 - Adoção da Arquitetura Hexagonal

## Status: Aceito

## Data: 09/07/2026

## Última Atualização: 09/07/2026

## Contexto

Após definir o Monólito Modular como estilo arquitetural do GymFlow, tornou-se necessário estabelecer uma organização interna para cada módulo da aplicação.

O projeto possui como objetivo não apenas entregar uma solução para gestão de academias, mas também servir como ambiente de estudo para práticas modernas de Engenharia de Software.

Dessa forma, era importante adotar uma arquitetura que mantivesse as regras de negócio independentes de detalhes tecnológicos, permitindo que decisões relacionadas à persistência, mensageria, APIs REST e integrações fossem tratadas como componentes substituíveis.

## Decisão

Foi adotada a Arquitetura Hexagonal (Ports and Adapters) como padrão arquitetural para todos os módulos do GymFlow.

Cada módulo será organizado em camadas com responsabilidades bem definidas, separando o domínio das tecnologias utilizadas para sua implementação.

As regras de negócio não deverão depender diretamente de frameworks, bancos de dados, mensageria ou protocolos de comunicação.

As integrações com recursos externos serão realizadas por meio de Ports (interfaces) implementadas por Adapters, preservando o isolamento do domínio.

De forma simplificada, cada módulo seguirá a seguinte estrutura:

```plaintext
application/
domain/
infrastructure/
presentation/
```

## Motivação

A adoção da Arquitetura Hexagonal foi motivada pelos seguintes fatores:

- Manter as regras de negócio independentes do framework Spring Boot.
- Facilitar testes unitários das regras de negócio sem necessidade de infraestrutura.
- Permitir substituir tecnologias de persistência ou mensageria com menor impacto no domínio.
- Reduzir o acoplamento entre regras de negócio e detalhes técnicos.
- Aproximar a arquitetura do GymFlow das práticas utilizadas em aplicações Java corporativas.
- Consolidar conhecimentos sobre Ports & Adapters por meio de uma aplicação real.

Além dos benefícios técnicos, esta decisão está alinhada ao objetivo de utilizar o GymFlow como projeto de estudo para Arquitetura de Software.

## Consequências

### Positivas

- Alto desacoplamento entre domínio e infraestrutura.
- Regras de negócio mais fáceis de testar.
- Maior facilidade para evolução tecnológica da aplicação.
- Melhor organização dos módulos.
- Possibilidade de reutilização dos casos de uso por diferentes interfaces (REST, mensageria ou outras integrações).

### Negativas

- Aumento da quantidade de classes e interfaces.
- Curva de aprendizado maior quando comparada a arquiteturas em camadas tradicionais.
- Necessidade de disciplina para manter a separação entre domínio e infraestrutura.

## Alternativas Consideradas

### Arquitetura em Camadas (Layered Architecture)

Foi considerada por ser amplamente utilizada em aplicações Spring Boot.

Entretanto, essa abordagem tende a aumentar o acoplamento entre regras de negócio, persistência e framework, dificultando a evolução da aplicação ao longo do tempo.

### Clean Architecture

Também foi considerada durante a definição da arquitetura.

Apesar de compartilhar princípios semelhantes aos da Arquitetura Hexagonal, sua organização costuma ser mais abrangente e conceitual.

Para o contexto do GymFlow, a Arquitetura Hexagonal apresentou uma estrutura mais objetiva e adequada aos objetivos do projeto.

## Revisão Futura

Esta decisão deverá permanecer válida durante toda a evolução do GymFlow.

Novas tecnologias poderão ser incorporadas, como Apache Kafka, Redis ou novos mecanismos de persistência, sem alterar a estrutura arquitetural definida neste ADR.

A Arquitetura Hexagonal continuará sendo o padrão para organização dos módulos, independentemente das tecnologias adotadas.
