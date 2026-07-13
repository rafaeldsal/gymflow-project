# Guia de Desenvolvimento

O objetivo deste guia é fornecer informações e instruções para desenvolvedores que estejam contribuindo para o projeto. Ele abrange desde a configuração do ambiente de desenvolvimento até as melhores práticas de codificação e testes.

## Organização do Projeto
O projeto foi pensando para ser um monolito modular, permitindo que diferentes partes do sistema sejam desenvolvidas e mantidas de forma independente. A estrutura de diretórios é organizada da seguinte maneira:

```text
gymflow/
├── bootstrap/
├── shared/
│
├── auth/
├── tenant/
├── unit/
├── student/
├── plan/
├── enrollment/
├── training/
├── notification/
│
├── gradle/
├── build.gradle
├── settings.gradle
├── .gitignore
└── ...
```
Cada módulo representa uma funcionalidade específica dentro do sistema e pode ser desenvolvido de forma isolada, facilitando a manutenção e evolução do projeto.

### Descrição dos Módulos
- **bootstrap:** É responsável pela inicialização do sistema.
- **shared:** Contém código compartilhado entre os diferentes módulos, como utilitários, constantes e classes comuns.
- **auth:** Gerencia a autenticação e autorização dos usuários.
- **tenant:** Lida com a gestão de múltiplos clientes (tenants) no sistema.
- **unit:** Contém funcionalidades relacionadas às unidades física de uma academia (Tenant).
- **student:** Gerencia informações e operações relacionadas aos alunos.
- **plan:** Responsável pela gestão de planos de assinatura e pacotes oferecidos aos alunos.
- **enrollment:** Lida com o processo de matrícula dos alunos nos planos e pacotes.
- **training:** Gerencia os treinos e exercícios disponíveis para os alunos.
- **notification:** Responsável pelo envio de notificações e mensagens para os usuários do sistema.

> Outros módulos podem ser adicionados conforme a necessidade do projeto, seguindo a mesma estrutura modular.

## Estrutura Interna dos Módulos

Para esse projeto, foi pensando em uma arquitetura hexagonal. O foco do projeto é manter a separação de responsabilidades e permitir que cada módulo seja desenvolvido de forma independente, facilitando a manutenção e evolução do sistema.

Todos os módulos devem seguir essa estrutura interna:

```text
<module>/
├── domain
│   ├── model
│   ├── repository
│   ├── service
│   └── event
│
├── application
│   ├── usecase
│   ├── command
│   ├── query
│   └── gateway
│
├── infrastructure
│   ├── persistence
│   ├── messaging
│   └── configuration
│
└── presentation
    ├── controller
    ├── request
    ├── response
    └── mapper
```

### Domain

Essa é a camada mais importante do sistema. Ela responde a pergunta:
> **"O que o sistema faz?"** ou **"Como funciona o negócio?"**

Nessa camada os módulos não tem conhecimento de REST, Banco de dados, Mensageria ou qualquer outra tecnologia. Ela é responsável por representar o domínio do negócio e suas regras.

#### Detalhes dos Pacotes
- **model:** Contém os objetos de domínio, que representam as entidades e agregados do sistema. Eles encapsulam o estado e o comportamento do negócio.
- **repository:** Define as interfaces para persistência de dados. Os repositórios são responsáveis por abstrair o acesso aos dados, permitindo que a camada de domínio não dependa de detalhes de implementação.
- **service:** Contém a lógica de negócio que não se encaixa diretamente nos modelos de domínio. Os serviços de domínio são responsáveis por coordenar operações complexas e aplicar regras de negócio que envolvem múltiplos objetos de domínio.
- **event:** Define os eventos de domínio que representam mudanças significativas no estado do sistema. Esses eventos podem ser usados para notificar outras partes do sistema sobre alterações importantes, permitindo uma comunicação desacoplada entre os módulos.

### Application
A camada de aplicação é responsável por orquestrar as operações do sistema, coordenando a execução dos casos de uso e interagindo com a camada de domínio. Ela responde a pergunta:

> **"Como o sistema faz?"** ou **"Como o usuário interage com o sistema?"**

Nessa camada não vemos detalhes de implementação de regra de negócio e nem de infraestrutura.

#### Detalhes dos Pacotes
- **usecase:** Contém os casos de uso do sistema, que representam as operações que podem ser realizadas pelos usuários ou por outros sistemas. Cada caso de uso encapsula a lógica necessária para executar uma operação específica, coordenando a interação entre os modelos de domínio e os repositórios.
- **command:** Define os objetos que representam intenções de escrita. Eles encapsulam os dados necessários para realizar uma operação de escrita no sistema, como criar, atualizar ou excluir entidades. São imutáveis, contendo apenas os dados, nada de lógica de negócio.
- **query:** Define os objetos que representam intenções de leitura. Eles encapsulam os dados necessários para realizar uma operação de leitura no sistema, como buscar informações ou consultar o estado atual das entidades. Assim como os comandos, são imutáveis e não contêm lógica de negócio.
- **gateway:** Define as interfaces para comunicação com sistemas externos, como APIs de terceiros, serviços de mensageria ou outros módulos do sistema. Os gateways permitem que a camada de aplicação interaja com o mundo externo de forma desacoplada, abstraindo os detalhes de implementação e facilitando a substituição ou atualização das integrações externas.

### Infrastructure
A camada de infraestrutura é responsável por fornecer suporte técnico e operacional para o sistema. Ela responde a pergunta:
> **"Como o sistema se conecta com o mundo externo?"**

#### Detalhes dos Pacotes
- **persistence:** Contém as implementações concretas dos repositórios definidos na camada de domínio. Ele lida com a persistência de dados, como acesso a bancos de dados relacionais ou não relacionais, e mapeamento objeto-relacional (ORM).
- **messaging:** Contém as implementações concretas dos gateways definidos na camada de aplicação. Ele lida com a comunicação com sistemas externos, como envio de mensagens para filas, tópicos ou serviços de mensageria, garantindo que a camada de aplicação possa interagir com o mundo externo de forma eficiente e confiável.
- **configuration:** Contém classes e arquivos de configuração que definem como o sistema deve se comportar em diferentes ambientes, como desenvolvimento, teste e produção. Ele também pode incluir configurações de bibliotecas, frameworks e serviços externos utilizados pelo sistema.

### Presentation
A camada de apresentação é responsável por lidar com a interação do usuário e a interface do sistema. Ela responde a pergunta:
> **"Como o usuário interage com o sistema?"**

Nosso projeto, a camada de apresentação é implementada utilizando o padrão REST, permitindo que os usuários interajam com o sistema por meio de APIs HTTP.

#### Detalhes dos Pacotes
- **controller:** Contém os controladores que recebem as requisições HTTP, processam os dados e retornam as respostas apropriadas. Eles atuam como intermediários entre a camada de aplicação e a camada de apresentação, garantindo que as operações sejam executadas corretamente e que os resultados sejam apresentados de forma adequada aos usuários.
- **request:** Define os objetos que representam as requisições recebidas pelos controladores. Eles encapsulam os dados enviados pelos usuários, como parâmetros de consulta, corpo da requisição e cabeçalhos HTTP. Esses objetos são usados para validar e processar as informações recebidas antes de serem passadas para a camada de aplicação.
- **response:** Define os objetos que representam as respostas enviadas pelos controladores. Eles encapsulam os dados que serão retornados aos usuários, como status da operação, mensagens de erro e informações solicitadas. Esses objetos garantem que as respostas sejam consistentes e padronizadas, facilitando a integração com clientes e outros sistemas.
- **mapper:** Contém classes responsáveis por converter objetos entre diferentes camadas do sistema, como transformar modelos de domínio em objetos de resposta ou vice-versa. Os mapeadores ajudam a manter a separação de responsabilidades entre as camadas, garantindo que cada camada trabalhe com os tipos de dados apropriados e facilitando a manutenção e evolução do sistema.

## Criando casos de uso

Por se tratar de um projeto com muitos módulos, as vezes poderá gerar dúvida onde colocar determinado caso de uso. Para obter essa informações, uma abordagem que pode ser utilizada é:

1. Pergunte qual contexto sofreu alteração com a mudança. Por exemplo, se você está alterando a forma como os alunos são matriculados em um plano, o contexto afetado é o módulo de **enrollment**. Logo, o caso de uso deve ser criado dentro do módulo de **enrollment**.

## Como decidir entre Entidade, Domain Service e Repository

Ao desenvolver alguma atividade, talvez você se depare com a dúvida de onde colocar determinada regra de negócio. Para isso, podemos seguir algumas diretrizes:

- **Entidade:** Se a a regra de negócio está relacionada a um único objeto de domínio, a regra deve ser implementada dentro da própria entidade. Por exemplo, se você está lidando com a validação de um CPF de um aluno, essa regra deve estar dentro da entidade **Student**.
- **Domain Service:** Se a regra de negócio envolve múltiplos objetos de domínio ou não se encaixa diretamente em uma única entidade, ela deve ser implementada em um serviço de domínio. Por exemplo, se você está lidando com a lógica de cálculo do valor total de uma matrícula, que envolve informações do aluno, do plano e do pacote, essa regra deve estar dentro de um **Domain Service**.
- **Repository:** Se a regra de negócio envolve a persistência de dados ou a recuperação de informações de um repositório, ela deve ser implementada dentro do repositório correspondente. Por exemplo, se você está lidando com a busca de alunos por CPF, essa regra deve estar dentro do repositório **StudentRepository**.

Pensando dessa forma, conseguimos manter a separação de responsabilidades e garantir que cada parte do sistema esteja focada em sua função específica, facilitando a manutenção e evolução do projeto.


## Convenções para Use Cases (Casos de Uso)

Para garantir que todos os casos de uso, de todos os módulos, sigam um padrão consistente, estabelecemos algumas convenções que devem ser seguidas durante o desenvolvimento:

1. **Nome do Caso de Uso:** O nome do caso de uso deve ser descritivo e indicar claramente a ação que ele realiza. Utilize verbos no infinitivo para iniciar o nome, seguido pelo objeto de domínio afetado. Sempre terminar com UseCase. Por exemplo: `CreateStudentUseCase`, `UpdateEnrollmentUseCase`, `DeletePlanUseCase`.
2. **Pacote do Caso de Uso:** Cada caso de uso deve ser colocado no pacote `usecase` dentro do módulo correspondente ao contexto afetado. Por exemplo, o caso de uso `CreateStudentUseCase` deve estar no pacote `student.application.usecase`.
3. **Comandos e Consultas:** Para cada caso de uso, crie classes de comando (command) e consulta (query) correspondentes, se necessário. Os comandos devem ser usados para operações de escrita, enquanto as consultas devem ser usadas para operações de leitura. Por exemplo, para o caso de uso `CreateStudentUseCase`, crie uma classe `CreateStudentCommand` para encapsular os dados necessários para criar um aluno, e uma classe `GetStudentByIdQuery` para buscar informações de um aluno específico.
