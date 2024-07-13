import pyautogui
import time
from datetime import datetime

def capture_screen():
    # PixyMon 창의 위치와 크기를 조정합니다.
    # 예를 들어, PixyMon이 화면의 좌측 상단에 있고 크기가 640x480인 경우
    x, y, width, height = 0, 0, 640, 480

    # 화면을 캡처합니다.
    screenshot = pyautogui.screenshot(region=(x, y, width, height))

    # 현재 시간을 기준으로 파일명을 생성합니다.
    timestamp = datetime.now().strftime('%Y%m%d_%H%M%S')
    filename = f'pixy2_capture_{timestamp}.png'

    # 이미지를 저장합니다.
    screenshot.save(filename)
    print(f'Captured and saved image: {filename}')

# 3초마다 이미지를 캡처하여 저장합니다.
try:
    while True:
        capture_screen()
        time.sleep(3)
except KeyboardInterrupt:
    print('Stopped capturing.')
