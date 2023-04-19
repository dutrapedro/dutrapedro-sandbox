# /bin/bash


docker stop faketwitter-cassandra
docker rm faketwitter-cassandra
docker build -t faketwitter-cassandra .
docker run --name faketwitter-cassandra -p 9042:9042 -d faketwitter-cassandra

while true
do
  if grep -qi "Startup complete" <(docker logs faketwitter-cassandra 2>&1); then
    docker exec faketwitter-cassandra cqlsh -f setup_keyspace.cql;
    echo "***Server ready to connect***";
    break;
  else
    echo "Server not ready yet!";
  fi

  sleep 2
done
