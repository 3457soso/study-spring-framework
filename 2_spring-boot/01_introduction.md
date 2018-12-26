# 스프링 부트 입문

**출처 : [백기선의 스프링 부트- 백기선 님](https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8//)**

#### 목차

1. **스프링 부트 시작하기 (소개 및 프로젝트 시작)**
2. 스프링 부트의 원리 (의존성 관리와 자동 설정)
3. 스프링 부트의 원리 (내장 웹 서버)
4. 스프링 부트의 핵심 기능 (SpringApplication)
5. 스프링 부트의 핵심 기능 (외부 설정)
6. 스프링 부트의 핵심 기능 (프로파일, 로깅, 테스트)
7. 스프링 부트의 기술 (웹 MVC)
8. 스프링 부트의 기술 (데이터베이스)
9. 스프링 부트의 기술 (보안 및 REST)
10. 스프링 부트의 운영 (Actuator)

___

## 스프링 부트 시작하기 (소개 및 프로젝트 시작)

### 1. 스프링 부트 소개

#### 1) 소개

- 스프링 부트는 제품 (production) 수준의 스프링 애플리케이션을 **빨리 만들 수 있게 도와준다**.

- **opinionated view** : 널리 쓰이는 설정을 기본적으로 제공해주기 때문에 직접 하지 않아도 된다. 
  - 기본적인 스프링 플랫폼에 대한 설정도 해주지만,

  - **써드파티**에 대한 부분도 해준다. ex) 톰캣 띄우기

    

#### 2) 목표

- **스프링 부트의 목표**

  - 스프링 개발을 할 때 빠르게!

  - convension of configuration을 제공한다. 하나하나 설정하지 말자!

  - 하지만 원하는대로 커스터마이징 하기도 편하다.

  - 비즈니스 로직 구현 뿐 아닌 **non-functional**도 제공해준다. ex) 서버, 보안, 헬스체크 등등

  - **XML configuration**과 **code generation**이 필요 없다!

    

### 2. 프로젝트 생성 및 구조 

- **프로젝트 생성하는 방법**

  1) *돈 주고 ...* **IntelliJ Ultimate** 버전을 사서 **Spring Initializer**로 프로젝트 생성하기

  2) Maven이나 Gradle으로 일반 자바 프로젝트를 만든 뒤에 **Spring 레퍼런스**를 참고해서 생성하기

  3) [start.spring.io](https://start.spring.io) 에서 스프링 프로젝트 생성하기

  4) 콘솔에서 명령어 설치해서 만드는 방법도 있기는 한데 *비추*...

  

- **프로젝트 생성 후 빌드하기**

  - **IDE에서 올리기**

    생성한 후에 `Application.java`를 실행시키면 바로 스프링 애플리케이션이 올라간다.

  - **cmd**에서 명령어로 올리기

    1) 루트 폴더에서 `mvn project` 로 패키징. 

    2) 이는 웹 프로젝트가 아니라 자바 프로젝트이기 때문에 **jar 파일**이 생긴다.

    3) `java -jar target/bootproject-1.0-SNAPSHOT.jar `을 하면 똑같이 실행할 수 있다.



- **스프링 프로젝트의 구조**

  - Maven 자바 기본 프로젝트의 구조와 동일하다

  - java : 자바 소스코드가 들어간다.

    - 메인 애플리케이션 클래스는 **디폴트 패키지의 최상위 패키지**에 만드는 것을 추천한다!

    - 컴포넌트 스캔과 관련된 이유 때문이라고 한다. *(이후 자세히...)*

      여기에 두면 해당 위치 이하의 클래스들을 빈으로 등록하게 된다.

  - resource : 자바 소스코드를 제외한 모든것이 들어간다!

    - 이 리소스들은 자바 애플리케이션에서...

      resource 폴더를 루트로 생각한 상태에서 모두 접근이 가능하다.

      

**+) 앞으로 공부하게 될 내용**

1. 스프링이 동작하려면 다양한 **dependency**를 가져와야 하는데 어떻게 자동으로 가져왔을까?
2. 스프링을 사용하기 위해서는 다양한 설정이 필요한데 그 과정이 왜 생략된걸까?
3. 톰캣을 따로 연결하지도 않았는데 어떻게 내장하고 있는걸까?