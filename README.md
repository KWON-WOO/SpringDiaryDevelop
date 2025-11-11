# 🗓️ Spring Diary

일정 공유 및 댓글 기능을 제공하는 웹 서비스입니다.  
비밀번호 기반 인증을 통해 일정 삭제 및 댓글 작성이 가능하며, 커스텀 예외 처리와 유효성 검사를 시행하는 API를 제공합니다.

---

# 📘 Diary API 명세서

## 📌 개요

Spring Boot 기반의 다이어리 프로젝트 API 명세서입니다. 일정과 유저, 댓글의 등록, 조회, 수정, 삭제 기능을 제공합니다.

비밀번호는 암호화 되어 저장됩니다.

---

## 📂 API 목록
- [일정CRUD](#-일정CRUD)
- [유저CRUD](#-유저CRUD)
- [댓글CRUD](#-댓글CRUD)
- [회원가입](#-회원가입)
- [로그인](#-로그인)

# 📅 일정 CRUD
## 1. 일정 생성
- **URL** : `/schedules`
- **Method** : `POST`
- **Request Body** :

    ```json
    {
      "name": "작성자명(String, 필수, 5자 이내)",
      "title": "일정 제목(String, 필수, 20자 이내)",
      "content": "일정 내용(String, 200자 이내)"
    }
    ```
- **Response**

    ```json
    {
      "name": "작성자명(String, 필수, 5자 이내)",
      "title": "일정 제목(String, 필수, 20자 이내)",
      "content": "일정 내용(String, 200자 이내)",
      "createdAt": "일정 생성일",
      "modifiedAt": "일정 수정일"
    }
    ```
- **Status Code**:
    - `201 Created`: 등록 성공
    - `400 Bad Request`: 입력값이 잘못됨.
    - `404 Not Found`: 요청 주소가 잘못됨.


## 2. 일정 조회
- **URL** : `/schedules`
- **Method** : `GET`
- **Request Body**:
    ```json
  {
  "name": "작성자명"
  }
    ```
- **Response**

    ```json
    {
      "id": "일정의 고유 ID",
      "name": "작성자명(String, 필수, 5자 이내)",
      "title": "일정 제목(String, 필수, 20자 이내)",
      "content": "일정 내용(String, 200자 이내)",
      "createdAt": "일정 생성일",
      "modifiedAt": "일정 수정일"
    }
    ```
- **Status Code**:
    - `200 OK`: 조회 완료.
    - `404 Not Found`: 잘못된 주소 입력.


### 3. 일정 수정
- **URL** : `/schedules/{id}`
- **Method** : `PATCH`
- **Request Body** :

    ```json
    {
      "name": "작성자명(String, 필수, 5자 이내)",
      "title": "일정 제목(String, 필수, 20자 이내)",
      "content": "일정 내용(String, 200자 이내)",
    }
    ```
- **Response**

    ```json
    {
      "id": "일정의 고유 ID",
      "name": "작성자명(String, 필수, 5자 이내)",
      "title": "일정 제목(String, 필수, 20자 이내)",
      "content": "일정 내용(String, 200자 이내)",
      "createdAt": "일정 생성일",
      "modifiedAt": "일정 수정일"
    }
    ```

- **Status Code**:
  - `200 OK`: 수정 완료.
  - `400 Bad Request`: 잘못된 요청값

### 4. 일정 삭제
- **URL** : `/schedules/{id}`
- **Method** : `DELETE`
- **Status Code**:
  - `204 No Content`: 삭제 완료.
  - `400 Bad Request`: 잘못된 입력값.


# 😀 유저 CRUD
### 1. 유저 회원가입
- **URL** : `/users`
- **Method** : `POST`
- **Request Body** :

    ```json
    {
      "name": "유저명",
      "password": "비밀번호",
      "email": "유저의 이메일"
    }
    ```
- **Response**

    ```json
    {
      "id": "유저의 고유 ID",
      "name": "유저명",
      "email": "유저의 이메일",
      "createdAt": "일정 생성일",
      "modifiedAt": "일정 수정일"
    }
    ```
- **Status Code**:
    - `201 Created`: 등록 성공
    - `400 Bad Request`: 입력값이 잘못됨.
    - `404 Not Found`: 요청 주소가 잘못됨.


### 2. 일정 조회
- **URL** : `/users`
- **Method** : `GET`
- **Request Body**:
    ```json
  {
  "name": "유저명"
  }
    ```
- **Response**

    ```json
    {
      "id": "유저의 고유 ID",
      "name": "유저명",
      "email": "유저의 이메일",
      "createdAt": "일정 생성일",
      "modifiedAt": "일정 수정일"
    }
    ```
- **Status Code**:
    - `200 OK`: 조회 완료.
    - `404 Not Found`: 잘못된 주소 입력.

### 3. 유저 수정
- **URL** : `/users`
- **Method** : `PATCH`
- **Request Body** :

```json
{
  "name": "유저명",
  "email": "유저 이메일"
}
```
- **Response**

```json
{
  "id": "유저의 고유 ID",
  "name": "유저명",
  "email": "유저의 이메일",
  "createdAt": "일정 생성일",
  "modifiedAt": "일정 수정일"
}
```
- **Status Code**:
  - 

### 4. 일정 삭제
- **URL** : `/schedule`
- **Method** :
- **Request Body** :

```json
{
  
}
```
- **Response**

```json
{
  
}
```
- **Status Code**:
  - 


# 🗨️ 댓글 CRUD
### 1. 일정 생성
- **URL** : `/comments/`
- **Method** : `POST`
- **Request Body** :

    ```json
    {
      "name": "작성자명(String, 필수, 5자 이내)",
      "title": "일정 제목(String, 필수, 20자 이내)",
      "content": "일정 내용(String, 200자 이내)"
    }
    ```
- **Response**

    ```json
    {
      "name": "작성자명(String, 필수, 5자 이내)",
      "title": "일정 제목(String, 필수, 20자 이내)",
      "content": "일정 내용(String, 200자 이내)",
      "createdAt": "일정 생성일",
      "modifiedAt": "일정 수정일"
    }
    ```
- **Status Code**:
    - `201 Created`: 등록 성공
    - `400 Bad Request`: 입력값이 잘못됨.
    - `404 Not Found`: 요청 주소가 잘못됨.

### 2. 일정 조회
- **URL** : `/schedule`
- **Method** :
- **Request Body** :

```json
{
  
}
```
- **Response**

```json
{
  
}
```
- **Status Code**:
  - 

### 3. 일정 수정
- **URL** : `/schedule`
- **Method** :
- **Request Body** :

```json
{
  
}
```
- **Response**

```json
{
  
}
```
- **Status Code**:
  - 

### 4. 일정 삭제
- **URL** : `/schedule`
- **Method** :
- **Request Body** :

```json
{
  
}
```
- **Response**

```json
{
  
}
```
- **Status Code**:
  - 


# 📝 회원가입
- **URL** : `/schedule`
- **Method** :
- **Request Body** :

```json
{
  
}
```
- **Response**

```json
{
  
}
```
- **Status Code**:
  - 


# 🔐 로그인
- **URL** : `/schedule`
- **Method** :
- **Request Body** :

```json
{
  
}
```
- **Response**

```json
{
  
}
```
- **Status Code**:
  -
