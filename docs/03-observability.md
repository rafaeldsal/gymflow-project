# Obervabilidade para o GymFlow

## Estratégia de Logs (O que queremos enxergar)

### Níveis de LOG por Ambiente:
  - **DEV:** DEBUG para todos os módulos.
  - **HML:** INFO com DEBUG espefíficos para módulos críticos.
  - **PRD:** WARN e ERROR, com INFO para eventos de negócio importante.

### O que logar em cada nível:
  - **ERROR:** Exceções não tratadas, falhas em integrações, erros de infraestrutura.
  - **WARN:** Tentativas de acesso negado, recursos quase esgotados, degradação de performance.
  - **INFO:** Mudança de estado importante (criação/atualização/remoção de recursos), fluxos de negócio principais.
  - **DEBUG:** Detalhes de execução, parametros de entrada e saída, decisões de roteamento.
  - **TRACE:** Fluxo completo de requisições, valores intermediários.

### Padrão da Estrutura de LOG:
```json
{
  "timestamp": "2024-06-01T12:00:00Z",
  "level": "INFO",
  "service": "gymflow-service",
  "module": "student",
  "correlationId": "123e4567-e89b-12d3-a456-426614174000",
  "tenantId": "tenant-123",
  "userId": "user-456",
  "traceId": "trace-789",
  "spanId": "span-101112",
  "message": "Student created successfully",
  "class": "CreatedStudentUseCase",
  "method": "execute",
  "duration": 150,
  "data": {
    "studentId": "stu-789",
    "email": "student@example.com" 
  },
  "tags": ["student", "creation", "success"]
}
```

#### Detalhes dos Campos:

Campos Obrigatórios:

- **timestamp**
  - **Formato:** "YYYY-MM-DDTHH:mm:ssZ" ISO 8601 com Timezone UTC (Z = Zulu Time).
  - **Significado:** Data e hora exata em que o log foi gerado.
  - **Como é preenchido:** Automaticamente pelo Logbakc no momento da geração do log.
  - **Para que serve:** Auditar quando eventos aconteceram, correlacionar logs com outros sistemas, analisar padrões de comportamento ao longo do tempo, rastrear ordem cronológica das operações.
- **level**
  - **Valores possíveis:** DEBUG, INFO, WARN, ERROR, TRACE.
  - **Significado:** Indica a severidade ou importância do log.
  - **Como é preenchido:** Determinado pelo desenvolvedor ao chamar `log.info()`, `log.debug()`, `log.warn()`, `log.error()` ou `log.trace()`.
  - **Para que serve:** Filtrar logs por nível de severidade, monitorar problemas críticos, analisar comportamento do sistema em diferentes níveis de detalhe.

Campos de Indentificação de Contexto:

- **service**
  - **Formato:** Nome do serviço ou aplicação. Exemplo: "gymflow-service".
  - **Significado:** Identifica qual serviço gerou o log.
  - **Como é preenchido:** Configurado via MDC (Mapped Diagnostic Context) ou propriedade da aplicação.
  - **Para que serve:** Identificar a origem do log em ambiente de múltiplos serviços e facilitar a busca em ferramentas de monitoramento.
- **module**
  - **Formato:** Nome do módulo ou componente da aplicação. Exemplo: "student", "payment".
  - **Significado:** Módulo específico da aplicação que gerou o log.
  - **Como é preenchido:** Definido no logger específico de cada módulo ou via pacote.
  - **Para que serve:** Facilitar a identificação de problemas em módulos específicos, melhorar a análise de logs por área funcional, isolar log por funcionalidade.

Campos de Rastreabilidade Distribuída:

- **correlationId**
  - **Formato:** UUID (Universally Unique Identifier). Exemplo: "123e4567-e89b-12d3-a456-426614174000".
  - **Significado:** Identificador único para correlacionar logs de uma mesma transação ou fluxo de negócio.
  - **Como é preenchido:** Recebido via header HTTP (X-Correlation-ID) ou gerado automaticamente no início de uma requisição e propagado entre serviços.
  - **Para que serve:** Rastrear a execução de uma operação distribuída, correlacionar logs entre diferentes serviços, facilitar a depuração de problemas em fluxos complexos.
- **traceId**
  - **Formato:** UUID ou string única. Exemplo: "trace-789".
  - **Significado:** Identificador de um trace (rastro) completo
  - **Como é preenchido:** Gerado pelo sistema de tracing distribuído (ex: Jaeger, Zipkin)
  - **Para que serve:** Rastreamento distribuido entre serviços, correlação com ferramenta de APM (Application Performance Monitoring), visualização do fluxo completo da requisição.
- **spanId**
  - **Formato:** UUID ou string única. Exemplo: "span-101112".
  - **Significado:** Identificador de um span (unidade de trabalho) dentro de um trace.
  - **Como é preenchido:** Cada operação dentro de um trace gera um novo spanId
  - **Para que serve:** Detalhar operações específicas dentro de uma requisição, Medir performance de partes específicas do código, Identificar gargalos em operações particulares.

Campos de Contexto de Negócio:

- **tenantId**
  - **Formato:** String representando o identificador do tenant. Exemplo: "tenant-123".
  - **Significado:** Identificador do cliente/tenant que está realizando a operação
  - **Como é preenchido:** Recebido via header HTTP (X-Tenant-ID) ou determinado pelo contexto da aplicação.
  - **Para que serve:** Isolamento de dados por tenant, Filtrar logs por cliente específico, Compliance (saber qual cliente causou determinada ação), Análise de uso por cliente
- **userId**
  - **Formato:** String representando o identificador do usuário. Exemplo: "user-456".
  - **Significado:** Identificador do usuário que está realizando a operação.
  - **Como é preenchido:** Recebido via header HTTP (X-User-ID) ou determinado pelo contexto da aplicação.
  - **Para que serve:** Rastrear ações específicas de usuários, Auditar operações por usuário, Analisar comportamento individual de usuários.

Campos de Execução:

- **message**
  - **Formato:** String descrevendo o evento ou ação. Exemplo: "Student created successfully".
  - **Significado:** Mensagem descritiva do que aconteceu.
  - **Como é preenchido:** Definida pelo desenvolvedor usando um padrão de mensagens.
  - **Para que serve:** Fornecer contexto sobre o evento registrado, Facilitar a leitura e compreensão do log, Ajudar na depuração de problemas.
- **class**
  - **Formato:** Nome da classe ou componente que gerou o log. Exemplo: "CreatedStudentUseCase".
  - **Significado:** Indica a classe ou componente responsável pela ação que gerou o log.
  - **Como é preenchido:** Automaticamente pelo Logger
  - **Para que serve:** Facilitar a identificação de onde o log foi gerado, Ajudar na depuração de problemas, Permitir análise de logs por componente ou classe específica.
- **method**
  - **Formato:** Nome do método ou função que gerou o log. Exemplo: "execute".
  - **Significado:** Indica o método ou função responsável pela ação que gerou o log.
  - **Como é preenchido:** Automaticamente pelo Logger ou via Aspect.
  - **Para que serve:** Facilitar a identificação de onde o log foi gerado, Debugging mais preciso, Performance analysis (identificar métodos lentos)

Campos de Performance:

- **duration**
  - **Formato:** Número inteiro representando a duração em milissegundos. Exemplo: 150.
  - **Significado:** Tempo total gasto na execução da operação ou método.
  - **Como é preenchido:** Calculado antes e depois da execução do método
  - **Para que serve:** Monitorar performance de operações, Identificar gargalos de performance, Analisar tendências de tempo de execução ao longo do tempo, Estabelecer SLAs (Service Level Agreements), Otimização de código.

Campos de Dados da Operação:

- **data**
  - **Formato:** Objeto JSON contendo dados relevantes da operação. Exemplo: `{"studentId": "stu-789", "email": "student@example.com"}`.
  - **Significado:** Contém informações detalhadas sobre a operação realizada.
  - **Como é preenchido:** Definido pelo desenvolvedor com base nos dados da operação.
  - **Para que serve:** Fornecer contexto adicional sobre a operação, Facilitar a análise de logs, Ajudar na depuração de problemas, Debugging de regras de negócio, Evitar a necessidade de consultas adicionais ao banco.

Campos de Categorização:
- **tags**
  - **Formato:** Array de strings representando categorias ou palavras-chave. Exemplo: `["student", "creation", "success"]`.
  - **Significado:** Palavras-chave para categorizar e filtrar logs
  - **Como é preenchido:** Definido pelo desenvolvedor com base na operação ou contexto.
  - **Para que serve:** Filtrar logs por categoria, Alertas específicos (ex: só logs com tag "security"), Dashboards customizados, Métricas por categoria.