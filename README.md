# O ms-logistica é um microserviço desenvolvido em Java que gerencia operações logísticas, incluindo o rastreamento de entregas e a gestão de frotas.

## Funcionalidades
### Rastreamento de Entregas: Monitoramento em tempo real do status e localização das entregas.

### Mensageria
Este microsserviço escuta mensagens dos seguintes tópicos:
* <code>novo-pedido-topic</code>
* <code>estoque-insuficiente-topic</code>

E produz mensagens para estes:
* <code>entrega-iniciada-topic</code>
* <code>entrega-concluida-topic</code>
* <code>entrega-status-topic</code>

### Environment Vars

* LOGISTICA_API_PORT    _(8082)_
* LOGISTICA_DB_USER     _(postgres)_
* LOGISTICA_DB_PASSWORD _(postgrespw)_
* LOGISTICA_DB_HOST     _(postgresql://localhost)_
* LOGISTICA_DB_PORT     _(55000)_
* LOGISTICA_DB_NAME     _(logisticadb)_
* LOGISTICA_BROKER_HOST _(localhost:9092)_