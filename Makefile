target := auto-invest-backend

run: docker-compse build 
	docker run -d --rm --env-file .env --name ${target} --network auto-invest_service-network -p 8080:8080 ${target} -d

db:
	docker compose up -d

docker-run:
	docker container run --restart always -d --network auto-invest-spring_service-network -p 8080:8080 --name ${target} ${target}

docker-stop:
	docker stop ${target}

docker-build:
	docker build -t ${target} .

mvn-build:
	mvn clean install

build: mvn-build docker-build

build-rerun: build docker-stop docker-run

mvn-run:
	./mvnw spring-boot:run

rebase-to-main:
	git checkout main && git pull && git switch - && git rebase -
