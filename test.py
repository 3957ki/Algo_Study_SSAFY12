import pandas as pd
import matplotlib.pyplot as plt
import numpy as np

# 데이터 로드
file_path = '/mnt/data/data.xlsx'
data = pd.read_excel(file_path)

# 색상 매핑
color_map = {1: 'green', 2: 'yellow', 3: 'gray'}

# 색상 데이터를 저장할 새로운 데이터프레임 생성
color_data = data.applymap(lambda x: color_map.get(x, 'white'))

# 차트 생성
fig, ax = plt.subplots(figsize=(10, 6))

# 색상 매트릭스로 변환하여 표시
for (i, j), val in np.ndenumerate(data):
    color = color_map.get(val, 'white')
    ax.add_patch(plt.Rectangle((j, i), 1, 1, color=color))
    ax.text(j + 0.5, i + 0.5, f'{val}', ha='center', va='center', color='black')

# 축 설정
ax.set_xlim(0, data.shape[1])
ax.set_ylim(0, data.shape[0])
ax.set_xticks(np.arange(data.shape[1]) + 0.5, minor=True)
ax.set_yticks(np.arange(data.shape[0]) + 0.5, minor=True)
ax.grid(which='minor', color='black', linestyle='-', linewidth=2)
ax.tick_params(which='minor', size=0)
ax.invert_yaxis()

# 차트 저장
chart_path = '/mnt/data/chart.png'
plt.savefig(chart_path)
plt.show()

chart_path
