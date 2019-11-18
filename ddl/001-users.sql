create table users (
  id bigserial primary key,
  username varchar,
  password_digest varchar
);

create unique index unique_index_on_users_username on users(username);
