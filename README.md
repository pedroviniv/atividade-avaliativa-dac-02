# atividade-avaliativa-dac-02
___
Resolução da 2º atividade avaliativa da disciplina Desenvolvimento de Aplicações Corporativas.

Este repositório divíde-se em três projetos:
1. jpa-bank, sendo a resolução do "Cenário 1 - Sistema Bancário"
2. jpa-oficina, sendo a resolução do "Cenário 2 - Oficina"
3. jpa-editora, sendo a resolução do "Cenário 3 - Editora"

Tanto projeto 1 (um) como o projeto 3 (três) listados acima contém uma classe nomeada "App" no pacote main.
Esta classe realiza a manipulação das entidades JPA de acordo com o que é peço nos requisitos de cada cenário
da atividade. (Qualquer informação refernte a atividade é descrito [neste documento](atividade.pdf).)

Porém, o projeto 2 (dois) foi desenvolvido usando Enterprise Java Beans (EJB) e Java Transaction API (JTA),
Desta forma, o projeto 2 contém dois módulos. O módulo `shared` e o módulo `core`.

No módulo `shared` estão todas as classes e interfaces que é compartilhada com o módulo `core` e com possíveis outros módulos caso fosse necessário. Desta maneira, o módulo `shared` contém:
- Classes de domínio já mapeadas utilizando Java Persistence API (JPA)
- Interfaces de serviços que são implementadas no módulo core.


