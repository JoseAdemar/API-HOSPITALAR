# API-HOSPITALAR
## API para realizar cadastramento de OS de pacientes
## Descrição do projeto da API
A API segue o seguinte modelo:
Foi criada uma entidade Paciente onde é colhido os dados do paciente.
Como: nome, cpf, idade, data de nascimento e telefone.
Após a coleta desses dados é possível atribuir esse paciente a uma ordem de serviço
onde foi criada outra entidade para o  cadastro da ordem de serviço onde é colhido
o nome da clínica que solicitou o exame o nome do médico que fez a solicitação o
nome do exame solicitado e o código do paciente. Com essas informações na tabela do
frontend é possível visualizar o nome da clinica o nome do médico o nome do paciente
o código do paciente o exame solicitado e data e hora que foi feito esse cadastro
podendo esses dados ser atualizados ou excluídos.
## Observações:
Na construção da API foi implementado a função de CRUD e também consultas dinâmicas com JPQL
e também a costumização das respostas http com ExceptionHandler. A API está operacional e rodando com o frontend feito em Angular.
endereço do projeto frontend no GitHub: https://github.com/JoseAdemar/API-HOSPITALAR-UI 
