import requests
import json

# 백준 핸들 리스트
handles = [
    "3957ki",
    "binaryarc",
    "rlaekwjd6545",
    "dlsxj101",
    "ejoy_1016",
    "gmltjd8002",
    "hyunddoing",
    "Shbak111",
    "kwonseon0827",
    "95dmstjs",
]

# 최신 3문제 (이 문제들은 무조건 요청)
force_update_problems = [2171, 20007, 3013]


# API 요청 함수
def fetch_problem_status(handle, problem_id):
    url = f"https://solved.ac/api/v3/search/problem?query=id%3A{problem_id}+%26+%40{handle}"
    response = requests.get(url)
    if response.status_code == 200:
        data = response.json()
        return data.get("count", 0)  # 1이면 푼 문제, 0이면 안 푼 문제
    else:
        print(f"⚠️ API 요청 실패: {handle} - 문제 {problem_id}")
        return None


# 기존 데이터 로드 (파일이 없으면 빈 딕셔너리 유지)
try:
    with open("boj_solved_data.json", "r", encoding="utf-8") as f:
        result = json.load(f)
except FileNotFoundError:
    result = {handle: [] for handle in handles}  # 빈 리스트 형태로 초기화

# 기존 데이터를 딕셔너리로 변환 (빠른 탐색을 위해)
converted_result = {
    handle: {str(item["id"]): item["solved"] for item in problems}
    for handle, problems in result.items()
}

# API 요청이 필요한 경우에만 실행
for handle in handles:
    updated_problems = []

    # 기존 데이터에서 풀이 여부가 0인 문제만 업데이트
    for problem, status in converted_result.get(handle, {}).items():
        if status == 0:
            new_status = fetch_problem_status(handle, int(problem))
            if new_status is not None:
                converted_result.setdefault(handle, {})[
                    str(problem)
                ] = new_status  # 🔄 수정됨

    # 강제 업데이트 문제는 무조건 요청
    for problem in force_update_problems:
        status = fetch_problem_status(handle, problem)
        if status is not None:
            converted_result.setdefault(handle, {})[str(problem)] = status  # 🔄 수정됨

    # 변환된 데이터를 다시 리스트 형태로 저장
    updated_problems = [
        {"id": pid, "solved": solved}
        for pid, solved in converted_result.setdefault(handle, {}).items()
    ]
    result[handle] = updated_problems


# JSON 파일로 저장
with open("boj_solved_data.json", "w", encoding="utf-8") as f:
    json.dump(result, f, indent=4)

print("✅ 데이터 저장 완료: boj_solved_data.json")
