
# 카카오페이 사전과제 

2019년 하반기 서버 개발자 사전과제를 제출합니다.


## Directories

```
    .
    ├── src                         
        ├── main                  
            ├── java                # 자바 파일
            ├── resources           # 리소스 파일
                ├── data            # csv 파일
                ├── mapper          # mybatis sql 파일
                ├── schema.sql      # 초기 sql 테이블 생성 파일
                ├── data.sql        # 초기 sql 데이터 생성 파일
    ├── test                   
        ├── java                    # unit test 파일 
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
- 인터넷뱅킹 접속 기기 ID 를 입력받아 2019 년도 인터넷뱅킹 접속 비율을 예측하는 API 를 개발하세요.


## API 전문
- HTTP method는 문제 대부분이 조회 API 기능이기 때문에 GET만 사용합니다.

# 빌드 및 실행 방법