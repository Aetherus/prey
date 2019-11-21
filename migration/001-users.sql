create table users (
  id bigserial primary key,
  username varchar,
  password varchar
);

create unique index unique_index_on_users_username on users(username);
