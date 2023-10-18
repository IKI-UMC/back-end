# IKI Back-end

![image](https://github.com/IKI-UMC/back-end/assets/89457065/5d6cb392-21ab-4a5f-8e25-62627a619eec)


> 어려운 기계?🙅‍♀️ 손으로 주문하는 전자 메뉴판! 🙆‍♀️ 
세상에서 가장 쉬운 키오스크☝️
> 
> 
> 개발 기간 : 2023.07.07 ~ 2023.08.31
> 
> 링크 : [iki.digital](https://iki.digital/)

<br>
‘익키IKI’ 프로젝트의 백엔드 서버 레포지토리입니다.
<br>

<br>


# 👇 연계 Frontend Repository

https://github.com/IKI-UMC/front-end

<br>

# 프로젝트 소개

![image](https://github.com/IKI-UMC/back-end/assets/89457065/d04e488b-2379-4b3c-a374-d567a64ca25b)

<br>
'익'숙한 '키'오스크의 앞글자를 따서 '익키'라는 이름을 사용하게 되었습니다. <br>
기존의 키오스크 화면은 불필요한 화면전환이 많다고 생각되어 꼭 필요한 화면인 메뉴판만 넣어서 사용하기에 가장 쉬운 키오스크를 만들자는 취지에서 개발하게 되었습니다.
<br>
<br>

<br>


# 🔨 개발 환경 및 사용 기술

### Frontend

<img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black"> <img src="https://img.shields.io/badge/react-61DAFB?style=for-the-badge&logo=react&logoColor=black"> <img src="https://img.shields.io/badge/html5-E34F26?style=for-the-badge&logo=html5&logoColor=white"> <img src="https://img.shields.io/badge/css-1572B6?style=for-the-badge&logo=css3&logoColor=white"> <img src="https://img.shields.io/badge/styledcomponents-DB7093?style=for-the-badge&logo=styledcomponents&logoColor=white">

### Backend

<img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white"> <img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white"> <img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white"> <img src="https://img.shields.io/badge/amazonec2-FF9900?style=for-the-badge&logo=amazonec2&logoColor=white">

### Team Collaboration Tools

<img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white"> <img src="https://img.shields.io/badge/git-F05032?style=for-the-badge&logo=git&logoColor=white"> <img src="https://img.shields.io/badge/notion-000000?style=for-the-badge&logo=notion&logoColor=white"> <img src="https://img.shields.io/badge/discord-5865F2?style=for-the-badge&logo=discord&logoColor=white"> <img src="https://img.shields.io/badge/figma-F24E1E?style=for-the-badge&logo=figma&logoColor=white">

<br>

<br>


# 🎯 프로젝트 목적

*만 55세 이상 고령층의 디지털 기술 이용 수준은 43.1점(100점 만점)으로 서울 시민 전체 평균 대비 32.7% 낮았으며, 75세 이상은 13.8%만이 키오스크를 사용한 경험이 있는 것으로 나타났다.* ([기사 발췌](https://www.hankyung.com/society/article/2022051694181))<br>
**→ 고령인구 비중이 확대됨에 따라, 키오스크 주문에서 어려움을 겪는 디지털 소외 현상이 지속적으로 발생하고 있다.**
<br>

<br><br>*“주문을 못하고 매장을 나온 적도 있죠. 밖에서 보고 키오스크만 있으면 안 들어가요. 겁이 나서요. 정할 건 많은데 뒤에 줄이 서 있으니 마음은 급해지고…. 혼동되면 더 못해요. ‘미안한데 이 다음을 모르겠다’며 뒷사람의 도움을 받기도 했어요. 바쁠 땐 나 때문에 방해될까 미안해서 시도도 안 해요.” -김중현씨(80)* ([기사 발췌](https://www.khan.co.kr/print.html?art_id=202210180600011))

**→  키오스크에 대한 두려움과 거부감으로 인해 사용을 꺼려는 현상 발생.**

<br><br>*여러 기관에서 노인을 대상으로 키오스크 교육이 시행되고 있으며, 서울디지털재단은 [고령층 친화 키오스크 적용 가이드](http://www.khan.co.kr/kh_storytelling/2022/kiosk_quiz/data/kiosk_guide.pdf)를 만들어 배포하는 등 다양한 노력을 기울이고 있다.*

**→ 그러나 키오스크에 대한 두려움과 거부감을 없애고 근본적인 문제를 해결하는 데에는 한계가 있다.**
<br>

<br>**이에 따라 기존 메뉴판을 그대로 옮긴 UI로 직관성을 높인 키오스크를 개발하게 되었습니다.**
<br>

<br>


<br>

# **📦** 페이지 별 기능



## 목차

- [로그인 UI](#로그인-UI)
- [메인화면 UI](#메인화면-UI)
- [관리자화면 UI](#관리자화면-UI)
<br>

## 로그인 UI

**로그인&회원가입 페이지** <br>

아이디, 비밀번호를 입력해 로그인을 하고,  <br>
아이디, 비밀번호, 상호명을 입력 받아 회원가입을 진행합니다.<br>
이후 진입페이지 에서는 주문 페이지와 관리자 페이지를 선택해 이동할 수 있습니다. <br>
진입 후 로고를 여러번 눌러 페이지 간 이동이 가능합니다.<br>

![image](https://github.com/IKI-UMC/back-end/assets/89457065/e64f4b78-4141-4cb7-9b06-2bafa9530d37)

![image](https://github.com/IKI-UMC/back-end/assets/89457065/bd16c2ee-41a1-4395-80ac-5fd855afab29)

![image](https://github.com/IKI-UMC/back-end/assets/89457065/0a2a4bec-8f2a-49f7-ad26-c0588752f471)


<br>

<br>

## 메인화면 UI

### 📍**주문 페이지**

메뉴 이름 - 기본 가격으로 구성된 메뉴 리스트를 확인할 수 있습니다.<br>
메뉴는 카테고리별로 나누어져 있으며 이름을 선택하면 상세 옵션 선택 창이 표시됩니다. <br>
선택된 메뉴는 파란색으로 표시되고 하단에 총 금액이 나타납니다. <br>

![image](https://github.com/IKI-UMC/back-end/assets/89457065/63d69f7b-8a34-4750-ba42-8dc2aabff76a)


<br>

### 상세 옵션

옵션의 이름과 가격이 표시됩니다. <br>
상단에 현재 선택된 메뉴 이름이 나타납니다. <br>
메뉴의 필수 옵션과 추가 옵션을 선택할 수 있습니다. <br>
선택을 완료하면 메뉴가 장바구니에 추가됩니다. <br>

![image](https://github.com/IKI-UMC/back-end/assets/89457065/4d4f6d43-3675-4055-bd05-05144143b537)


<br>

### 장바구니

하단 장바구니 열기를 누르면 현재 선택된 메뉴의 이름과 옵션, 가격, 수량이 리스트 형식으로 표시됩니다. <br>
리스트 우측 삭제 버튼을 통해 장바구니 내 메뉴를 삭제할 수 있습니다. <br>

![image](https://github.com/IKI-UMC/back-end/assets/89457065/aca12caa-9913-424d-bcb3-9329c8b14a84)


<br>

### 결제 페이지

결제 버튼을 누르면 포장/매장 선택 버튼이 표시됩니다.<br>
포장하기 / 먹고가기 중 하나를 선택하면 결제 단계가 진행됩니다. <br>
결제가 완료되면 주문 번호와 결제된 금액을 알려줍니다. <br>
영수증을 받거나 포인트를 적립할 수 있습니다.

![image](https://github.com/IKI-UMC/back-end/assets/89457065/c24e23b4-c410-495f-a209-c5e6e1bfd79e)

![image](https://github.com/IKI-UMC/back-end/assets/89457065/4d1be2ce-8bbf-4163-8ad5-3fc38f212bbf)

![image](https://github.com/IKI-UMC/back-end/assets/89457065/66ab8993-b5a5-4b8c-b15c-b2a5d3487c2d)

![image](https://github.com/IKI-UMC/back-end/assets/89457065/d7b3f09b-ee7f-456f-9511-5fdf19de46dc)


<br>

## 관리자화면 UI

### 카테고리 등록

등록된 카테고리명은 리스트 형식으로 표시되며 수정하기 버튼을 통해 이름을 입력하고 수정할 수 있습니다.<br>
화면 상단 카테고리 추가를 선택하면 리스트에 새 카테고리가 추가됩니다. <br>
메뉴 조회를 통해 메뉴 관리 메이지로 이동할 수 있습니다.<br>
상단에 있는 추가버튼에 연결되어 있는 팝업창을 이용하여, 카테고리를 추가 할 수 있습니다.<br>

![image](https://github.com/IKI-UMC/back-end/assets/89457065/1951ffb5-0069-4265-81f3-f70f6cad5178)

![image](https://github.com/IKI-UMC/back-end/assets/89457065/af2f4727-d859-456e-84d1-556a180878cf)


<br>

### 메뉴 조회

등록된 메뉴명과 가격이 리스트로 표시됩니다. <br>
메뉴 추가를 통해 새 메뉴를 등록할 수 있습니다. <br>
수정/품절관리 팝업창으로 이름과 가격을 입력할 수 있고, 품절 여부 체크 또한 가능합니다.<br>
<br>

![image](https://github.com/IKI-UMC/back-end/assets/89457065/9eba9f48-27ce-4542-97c0-e6cccb08fe8c)

![image](https://github.com/IKI-UMC/back-end/assets/89457065/35b7744d-1a6a-4c0b-8bcd-f263bffc0825)


<br>

### 옵션 관리

옵션 카테고리와 세부 내용이 표시됩니다. <br>
카테고리 내 옵션 추가를 선택하면 해당 카테고리 리스트에 새 항목이 추가됩니다. <br>
수정하기 팝업을 통해 옵션명과 가격을 입력 및 수정할 수 있습니다. <br>
필수 카테고리에 체크하면 필수 옵션으로 등록됩니다.<br>

![image](https://github.com/IKI-UMC/back-end/assets/89457065/2ab271ff-8a85-425f-98d2-a52283de9d3a)

![image](https://github.com/IKI-UMC/back-end/assets/89457065/3f3e2379-7f06-457e-8b77-cb0c78feac35)


<br>

# 👇 Notion 링크

[https://www.notion.so/IKI-0b804dba91dc47d4aa32ebca97b9450d](https://www.notion.so/0b804dba91dc47d4aa32ebca97b9450d?pvs=21)
