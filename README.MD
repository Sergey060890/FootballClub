#TaskFootballClub

Реализовать промежуточный проект(каждому дал индивидуально).
В нем два maven подмодуля, один -repository, второй - service. 
Подключить checkstyle, jacoco.

В maven подмодуле repository реализовать маппинг на JPA entity(Hibernate), 
создать DAO используя параметризацию класса через Generic.
Базу создавать через liquibase.
Покрыть тестами используя H2(базу накатывать через Hibernate).

В maven подмодуле service реализовать подключение maven подмодуля repository. 
Реализовать класс содердащий main. 
В main методе наполнить базу тестовыми данными через DAO.