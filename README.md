# 📗 일정 관리 애플리케이션 (Standard MVP)

## 1. ERD (데이터 구조)

### [schedule 테이블]
* **id**: 고유 식별자 
* **title**: 제목
* **content**: 내용
* **assignee**: 작성자
* **password**: 비밀번호
* **created_at**: 등록일자
* **updated_at**: 수정일자 

---

## 2. API 명세서

| 기능 | Method | URL | 요청 데이터 (Request) | 반환 데이터 (Response) |
| :--- | :--- | :--- | :--- | :--- |
| **일정 생성** | `POST` | `/api/schedules` | title, content, assignee, password | id, title, content, assignee, createdAt, updatedAt |
| **단건 조회** | `GET` | `/api/schedules/{id}` | - | id, title, content, assignee, createdAt, updatedAt |
| **전체 조회** | `GET` | `/api/schedules`| - | 일정 목록 (id, title, content, assignee, 필수 필드 포함) |
| **선택 수정** | `PUT` | `/api/schedules/{id}` | title, assignee, password | id, title, content, assignee, createdAt, updatedAt |
| **선택 삭제** | `DELETE` | `/api/schedules/{id}` | password | 일정이 성공적으로 삭제되었습니다. |

* 모든 응답 데이터에서 사용자의 **비밀번호(`password`) 필드는 완전히 제외** 하고 반환.
