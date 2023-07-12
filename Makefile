startapp:
	mvn clean package
	docker-compose up --build
bashdb:
	docker exec -it book_store_db bash
logsapp:
	docker logs main_application