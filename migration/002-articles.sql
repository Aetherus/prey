create table articles (
  id bigserial primary key,
  user_id bigint not null references users(id),
  title varchar,
  content text
);

create index index_on_articles_user_id on articles(user_id);
