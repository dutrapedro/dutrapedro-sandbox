CREATE KEYSPACE faketwitter_posts WITH replication = {'class' : 'SimpleStrategy', 'replication_factor' : 1};

CREATE TABLE faketwitter_posts.post (
   id UUID PRIMARY KEY,
   description text,
   type int,
   post_id UUID,
   created_at timestamp );

CREATE TABLE faketwitter_posts.user (
   id UUID PRIMARY KEY,
   username text,
   created_at timestamp );


INSERT INTO faketwitter_posts.user (id, username, created_at) VALUES (
    uuid(), 'maria', toTimestamp(now())
);

INSERT INTO faketwitter_posts.user (id, username, created_at) VALUES (
    uuid(), 'john', toTimestamp(now())
);

INSERT INTO faketwitter_posts.user (id, username, created_at) VALUES (
    uuid(), 'elton', toTimestamp(now())
);

INSERT INTO faketwitter_posts.user (id, username, created_at) VALUES (
    uuid(), 'chloe', toTimestamp(now())
);
