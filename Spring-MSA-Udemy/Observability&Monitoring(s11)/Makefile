VERSION = s11

up:
	cd compose/default && docker compose up -d

down:
	cd compose/default && docker compose down

build: accounts gatewayserver cards loans eureka configserver

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

.PHONY: build up all accounts gatewayserver cards loans eureka configserver
