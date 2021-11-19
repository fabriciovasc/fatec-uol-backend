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
  registration_name_browser varchar(255) not null,
  registration_version_browser varchar(255) not null,
  registration_system varchar(255) not null,
  registration_gpu_model varchar(255) not null,
  registration_ip varchar(255) not null,
  registration_duration_time int not null,
  registration_accepted_terms_time int not null,
  registration_start_date_register varchar(255) not null,
  registration_end_date_register varchar(255) not null,
  registration_scroll_x varchar(1000) not null,
  registration_scroll_y varchar(1000) not null,
  registration_scroll_millis varchar(1000) not null,
  registration_unique_hash varchar(255) not null,
  primary key (registration_id),
  unique key uni_registration_email (registration_email)
);
