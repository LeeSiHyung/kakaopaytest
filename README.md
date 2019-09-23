
# 카카오페이 사전과제 

2019년 하반기 서버 개발자 사전과제를 제출합니다.


## Directories

```
    .
    ├── src                         
        ├── main                  
            ├── java                            # 자바 파일
            ├── resources                       # 리소스 파일
                ├── data                        # csv 파일
                ├── mapper                      # mybatis sql 파일
                ├── schema.sql                  # 초기 sql 테이블 생성 파일
                ├── data.sql                    # 초기 sql 데이터 생성 파일
    ├── test                   
        ├── java                                # unit test 
        ├── com.kaka.kakaopay.config            # config bean unit test 
        ├── com.kaka.kakaopay.controller        # controller unit test 
        ├── com.kaka.kakaopay.repository        # repository unit test 
        ├── com.kaka.kakaopay.service           # service unit test 
        ├── com.kaka.kakaopay.util              # util unit test 
        ├── com.kaka.kakaopay.InitDataTest      # csv 파일 생성 unit test  
    └── README.md
```



## 개발 프레임워크

- JDK1.8
- 스프링부트 2.1.8.RELEASE
- H2
- Mybatis

## 문제해결 전략


기본
- 인터넷뱅킹 서비스 접속 기기 목록을 출력하는 API 를 개발하세요
    - 기본 DB 조회 후 출력
- 각 년도별로 인터넷뱅킹을 가장 많이 이용하는 접속기기를 출력하는 API 를 개발하세요.
    - 자바 stream을 이용해 연도별 groupingBy 후 Collectors.maxBy를 통해 가장 많은 접속 기기를 가져옴
- 특정 년도를 입력받아 그 해에 인터넷뱅킹에 가장 많이 접속하는 기기 이름을 출력하세요.
    - 자바 parallelStream 이용해 특정 연도를 filter한 후 max를 통해 가장 많은 접속 기기를 가져옴

- 디바이스 아이디를 입력받아 인터넷뱅킹에 접속 비율이 가장 많은 해를 출력하세요
    - 자바 parallelStream 이용해 디바이스 아이디를 filter한 후 max를 통해 가장 많은 접속 정보를 가져옴

옵션
- 성능을 고려하여 10000 TPS 이상의 요청을 받을 수 있는 아키텍처에 대해서 고민해서 API 개발 시 반영해주세요. (오픈 소스나 여타 다른 SW 가 필요할 경우 면접 시에 의견을 말씀해주세요.)
    - 블록킹 방식의 JDBC 사용을 최소화 하고, 부하를 어플리케이션 비즈니스 로직으로 옮김, 부하가 늘어날 경우 수평적 확장을 진행함.
    - webflux를 통해 비동기, 논블로킹 방식으로 구현


## API 전문
- HTTP method는 문제 대부분이 조회 API 기능이기 때문에 GET만 사용합니다.
​- Swagger API-Document UI
    - http://localhost:8080/swagger-ui.html


# 빌드 및 실행 방법
​ gradle build && java -jar build/libs/kakaopay-0.0.1-SNAPSHOT.jar
