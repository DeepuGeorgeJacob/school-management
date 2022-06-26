    alter table courses_like
       add constraint FK_course
       foreign key (course_id)
       references course;

    alter table courses_like
       add constraint FK_student_course
       foreign key (student_id)
       references student;

    alter table performance
       add constraint FK_student_performance
       foreign key (student_id)
       references student;

    alter table student
       add constraint FK_guardian
       foreign key (guardian_id)
       references guardian;

    alter table student
       add constraint FK_student_details
       foreign key (student_details_id)
       references student_details;