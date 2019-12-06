create table singer_audit(
    id int not null AUTO_INCREMENT,
    first_name varchar(60) not null,
    last_name varchar(40) not null,
    birth_date date,
    version int not null default 0,
    created_by varchar(20),
    created_date timestamp,
    last_modified_by varchar(20),
    last_modified_date timestamp,
    unique UQ_SINGER_AUDIT_1(first_name, Last_name),
    primary key(id)
);

create table singer_audit_h(
    id int not null auto_increment,
    first_name varchar(60) not null,
    last_name varchar(40) not null,
    birth_date date,
    version int not null default 0,
    created_by varchar(20),
    created_date timestamp,
    last_modified_by varchar(20),
    last_modified_date timestamp,
    audit_revision int not null,
    action_type int,
    audit_revision_end int,
    audit_revision_end_ts timestamp,
    unique UQ_SINGER_AUDIT_H_1(first_name, last_name),
    primary key(id, audit_revision)
);

create table revinfo(
    revtstmp bigint not null,
    rev int not null auto_increment,
    primary key(revtstmp, rev)
);