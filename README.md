# Proposta de Projeto: API RESTful para Gerenciamento de Folha de Pagamento

## Objetivo:

Desenvolver uma API RESTful simples e robusta em Java com Spring Boot para gerenciar a folha de pagamento de uma empresa. A API permitirá a consulta, criação, atualização e exclusão de dados relacionados à folha de pagamento, como:

- Funcionários
- Cargos
- Departamentos
- Horas trabalhadas
- Faltas
- Lançamentos (férias, abonos, etc.)
- Salários
- Descontos
- Impostos
- Holerites

## Tecnologias:

- Linguagem de programação: Java
- Framework: Spring Boot
- Banco de dados: MySQL
- Documentação da API: Swagger

## Funcionalidades:

1. Funcionários:

    - Consultar, criar, atualizar e excluir funcionários.
    - Obter dados específicos de um funcionário (nome, cargo, departamento, etc.).

2. Cargos:

    - Consultar, criar, atualizar e excluir cargos.
    - Obter informações sobre um cargo específico (salário base, benefícios, etc.).

3. Departamentos:

    - Consultar, criar, atualizar e excluir departamentos.
    - Obter informações sobre um departamento específico (gerente, funcionários, etc.).

4. Horas Trabalhadas:

    - Registrar horas trabalhadas por funcionário.
    - Consultar o histórico de horas trabalhadas.

5. Faltas:

    - Registrar faltas por funcionário.
    - Consultar o histórico de faltas.

6. Lançamentos:

    - Registrar lançamentos (férias, abonos, etc.) para um funcionário.
    - Consultar o histórico de lançamentos.

7. Salários:

    - Calcular o salário líquido de um funcionário.
    - Consultar o histórico de salários.

8. Descontos:

    - Gerenciar descontos (INSS, imposto de renda, etc.).
    - Consultar o histórico de descontos.

9. Impostos:

    - Calcular impostos (INSS, imposto de renda, etc.).
    - Consultar o histórico de impostos.

10. Holerites:

    - Gerar holerites dos funcionários.
    - Consultar o histórico de holerites.

## Segurança:

- Autenticação e autorização via JWT.
- Controle de acesso granular por role.

## Documentação:

- Documentação completa da API disponível no Swagger.

