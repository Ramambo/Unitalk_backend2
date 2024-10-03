# Unitalk Project

<p align ="center"><img src="../662f9b48185c06bb.png" width = 40%></p>

- 상담관리 시스템 구축 프로젝트입니다.

</br>

## 목표

- 기업 협업 프로젝트 진행

</br>

## 기술스택

### ***FrontEnd***
![HTML5](https://img.shields.io/static/v1?style=for-the-badge&color=E34F26&message=HTML5&logo=HTML5&logoColor=white&label=)
![CSS](https://img.shields.io/static/v1?style=for-the-badge&color=1572B6&message=CSS&logo=CSS3&logoColor=white&label=)
![JAVASCRIPT](https://img.shields.io/static/v1?style=for-the-badge&color=F7DF1E&message=JAVASCRIPT&logo=JavaScript&logoColor=white&label=)
<img src="https://img.shields.io/badge/react.js-61DAFB?style=for-the-badge&logo=react&logoColor=black"/>

### ***BackEnd***
![Java](https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white)
<img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white"/>
<img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white"/>
<img src="https://img.shields.io/badge/aws-232F3E?style=for-the-badge&logo=amazonaws&logoColor=white"/>
<img src="https://img.shields.io/badge/linux-FCC624?style=for-the-badge&logo=linux&logoColor=black"/>

### ***VCS***
<img src="https://img.shields.io/badge/git-F05032?style=for-the-badge&logo=git&logoColor=white"/> <img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white"/>

</br>

## 개발기간
- 2024.06.14 ~ 2024.07.12 (기간 내 완료 목표)

</br>
</br>

## 구성원

<table>
	<tbody>
		<tr>
			<th><img width="150px" src="https://github.com/HeegeneChae.png" alt="HeegeneChae"/></th>
			<th><img width="150px" src="https://github.com/star-kw.png" alt="star-kw"/></th>
			<th><img width="150px" src="https://github.com/Ramambo.png" alt="Ramambo"/></th>
		</tr>
		<tr>
			<th><a href="https://github.com/HeegeneChae" target="_blank">HeegeneChae</a></th>
			<th><a href="https://github.com/star-kw" target="_blank">star-kw</a></th>
			<th><a href="https://github.com/Ramambo" target="_blank">Ramambo</a></th>
		</tr>
		<tr>
			<th><img width="150px" src="https://github.com/Jamie-Nestor90.png" alt="Jamie"/></th>
			<th><img width="150px" src="https://github.com/RbCream.png" alt="RbCream.png"/></th>
			<th><img width="150px" src="https://github.com/JinyDev95.png" alt="JinyDev95"/></th>
		</tr>
		<tr>
			<th><a href="https://github.com/Jamie-Nestor90" target="_blank">Jamie</a></th>
			<th><a href="https://github.com/RbCream" target="_blank">RbCream</a></th>
			<th><a href="https://github.com/JinyDev95" target="_blank">JinyDev95</a></th>
		</tr>
	</tbody>
</table>



# Unitalk_backend 폴더구조

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── unitalk/
│   │           ├── common/
│   │           │   ├── config/
│   │           │   ├── exception/
│   │           │   ├── model/
│   │           │   └── util/
│   │           ├── counseling/
│   │           │   ├── controller/
│   │           │   ├── service/
│   │           │   ├── repository/
│   │           │   └── model/
│   │           ├── emp/
│   │           │   ├── controller/
│   │           │   ├── service/
│   │           │   ├── repository/
│   │           │   └── model/
│   │           ├── login/
│   │           │   ├── controller/
│   │           │   ├── service/
│   │           │   ├── repository/
│   │           │   └── model/
│   │           ├── online/
│   │           │   ├── controller/
│   │           │   ├── service/
│   │           │   ├── repository/
│   │           │   └── model/
│   │           ├── program/
│   │           │   ├── controller/
│   │           │   ├── service/
│   │           │   ├── repository/
│   │           │   └── model/
│   ├── resources/
│   │   ├── static/
│   │   │   ├── css/
│   │   │   ├── img/
│   │   │   └── js/
│   │   ├── templates/
│   │   │   ├── fragment/
│   │   │   └── view/
│   │   └── etc/
│   │       ├── ddl/
│   │       └── dummydata/
```
## 폴더구조 정의

- common: 공통 패키지로, 프로젝트 전반에 걸쳐 사용되는 구성, 예외 처리, 모델, 유틸리티 클래스를 포함합니다.
  - config: 설정 관련 클래스
  - exception: 예외 처리 관련 클래스
  - model: 공통 모델 클래스
  - util: 유틸리티 클래스
- 각 도메인별 , 각각의 도메인에 관련된 컨트롤러, 서비스, 리포지토리, 모델 클래스를 포함합니다.
    <br/>(counseling, emp, login, online, program)
  - controller: REST API 또는 웹 컨트롤러 클래스
  - service: 비즈니스 로직을 포함하는 서비스 클래스
  - repository: 데이터 액세스 레이어 클래스
  - model: 도메인 모델 클래스
- resources:
  - static: 정적 리소스 (CSS, 이미지, JavaScript 파일 등)
  - templates: 템플릿 파일 (HTML 템플릿 등)
    - fragment: 템플릿 조각
    - view: 뷰 템플릿
  - etc: 기타 리소스
    - ddl: DDL 파일
    - dummydata: 더미 데이터 파일
    
