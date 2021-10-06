create schema uol;

use uol;

create user 'user'@'localhost' identified by 'pass123';

grant select, insert, delete, update on uol.* to user@'localhost';

create table registration (
  registration_id bigint unsigned not null auto_increment,
  registration_email varchar(255) not null,
  registration_password varchar(255) not null,
  registration_name varchar(255) not null,
  registration_cellphone varchar(100) not null,
  registration_user_agent varchar(255) not null,
  registration_fonts varchar(255) not null,
  registration_name_browser varchar(255) not null,
  registration_version_browser varchar(255) not null,
  registration_system varchar(255) not null,
  registration_version_system varchar(255) not null,
  registration_gpu_model varchar(255) not null,
  registration_ip varchar(255) not null,
  primary key (registration_id),
  unique key uni_registration_email (registration_email)
);

create table profile (
  profile_id bigint unsigned not null auto_increment,
  profile_uuid varchar(100) not null,
  profile_unique_hash varchar(255) not null,
  primary key (profile_id),
  unique key uni_profile_uuid (profile_uuid)
);

create table profile_registration (
  profile_id bigint unsigned not null,
  registration_id bigint unsigned not null,
  primary key (profile_id, registration_id),
  foreign key pr_profile_fk (profile_id) references profile (profile_id) on delete restrict on update cascade,
  foreign key pr_registration_fk (registration_id) references registration (registration_id) on delete restrict on update cascade
);
