startapp:
	mvn clean package
	docker-compose up --build
bashdb:
	docker exec -it book_store_db bash
logsapp:
	docker logs main_application
rmvolume:
	docker rm book_store_db
	docker volume rm bookonlinestore_book_store_volume