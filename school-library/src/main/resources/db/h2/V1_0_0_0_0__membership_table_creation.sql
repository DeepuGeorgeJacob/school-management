create table student_membership (
       id integer generated by default as identity,
       membership_number integer not null auto_increment,
       student_id integer not null,
       created_date TIMESTAMP not null,
       primary key (id)
);
