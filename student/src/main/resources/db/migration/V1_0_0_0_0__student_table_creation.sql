create table course (
       id integer generated by default as identity,
        name varchar(255),
        primary key (id)
    );

    create table courses_like (
       student_id integer not null,
        course_id integer not null
    );

    create table guardian (
       id integer generated by default as identity,
        contact_number varchar(255),
        name varchar(255),
        primary key (id)
    );

    create table performance (
       id integer generated by default as identity,
        best_performance integer not null,
        last_performance integer not null,
        student_id integer,
        primary key (id)
    );

    create table student (
       id integer generated by default as identity,
        first_name varchar(255),
        last_name varchar(255),
        guardian_id integer,
        student_details_id integer,
        primary key (id)
    );

    create table student_details (
       id integer generated by default as identity,
        age integer not null,
        contact_number varchar(255),
        date_of_birth varchar(255),
        primary key (id)
    );