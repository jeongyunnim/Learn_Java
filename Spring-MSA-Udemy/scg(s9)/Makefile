VERSION = s9

build:
	cd accounts && ./gradlew jib
	cd gatewayserver && ./gradlew jib
	cd cards && ./mvnw compile jib:build
	cd loans && ./mvnw compile jib:build
	cd eureka && ./gradlew jib
	cd configserver && ./gradlew jib

up:
	cd compose/default && docker compose up -d

down:
	cd compose/default && docker compose down

.PHONY: build up
