## Versão Português
### Fila de Mensagens (Exchange Padrão)
Quando criamos uma fila de mensagens, ela funciona de forma direta em uma única fila. Cada nova mensagem publicada pelos clientes será distribuída em um formato round-robin para os atendentes, com o objetivo de agilizar o atendimento.

### Anúncio de Novos Sabores (Exchange Fanout)
Os anúncios de novos sabores funcionam no modelo fanout, que, diferente da Exchange Padrão, distribui as mensagens para todos os ouvintes de maneira igualitária. Ou seja, todas as mensagens publicadas pelo Publisher são enviadas para todos os ouvintes simultaneamente.

## English Version
### Message Queue (Default Exchange)
When we create a message queue, it works in a direct manner with a single queue. Each new message published by the clients will be distributed in a round-robin format to the attendants, aiming to speed up the service.

### New Flavors Announcement (Fanout Exchange)
The announcements of new flavors work in a fanout model, which, unlike the Default Exchange, distributes the message equally to all listeners. In other words, all messages published by the Publisher are sent to all listeners simultaneously.