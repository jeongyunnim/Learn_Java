VERSION = s14
DOCKER_USER = jeongyun7521

up:
	cd compose/default && docker compose up -d

down:
	cd compose/default && docker compose down

build: accounts gatewayserver cards loans eureka configserver message

accounts:
	cd accounts && ./gradlew jib

gatewayserver:
	cd gatewayserver && ./gradlew jib

cards:
	cd cards && ./mvnw compile jib:build

loans:
	cd loans && ./mvnw compile jib:build

eureka:
	cd eureka && ./gradlew jib

configserver:
	cd configserver && ./gradlew jib

message:
	cd message && ./gradlew jib

re: clean up

clean: down
	docker images -a | grep "jeongyun7521/" | awk '{print $$3}' | xargs docker rmi

.PHONY: build up all accounts gatewayserver cards loans eureka configserver message re clean
