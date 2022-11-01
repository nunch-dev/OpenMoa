# OpenMoa Project

이 프로젝트는 모아키를 오픈 소스로 재구현하는 프로젝트입니다.

## 시작하기 전에

### 모아키는 무엇인가요?

모아키는 삼성전자가 개발한 터치 디바이스에서의 입력 방식입니다.  자음을 누른 뒤
조합을 원하는 모음이 가리키는 방향(예를 들어 'ㅏ'의 경우 오른쪽)으로 드래그하면
누른 자음과 드래그한 방향의 모음이 조합된 한글이 입력되는 동작이 대표적인
특징입니다. 자세한 동작 영상은 [공식 유튜브 영상][1]을 참조하세요.

### 왜 재구현하나요?

삼성전자의 모아키는 한때 구글 플레이에서 기기의 종류에 상관 없이 다운로드를
받을 수 있었습니다. 그러나 이 글을 작성하는 시점에는 구글 플레이에서 다운로드가
불가능합니다. 이로 인해 지금은 모아키를 사용하려면 삼성 키보드가 내장된
삼성전자 출시 스마트폰을 사용해야만 합니다. 저는 현재 삼성전자의 스마트폰을
사용하지 않고 있기 때문에 모아키를 제 스마트폰에서 사용할 수 있는 방법이
필요했습니다.

### 특허에 대하여

삼성전자의 모아키 입력 방식은 [터치 디바이스에서 문자 입력 방법 및 장치][2]라는
특허로 등록되어 보호되고 있습니다. 이 저장소를 공개하는 행위와 저장소에
[MIT 라이선스](LICENSE.md)를 적용하는 행위는 명시적으로든 암시적으로든 특허의
실시권을 가지지 않은 자의 특허 실시가 가능함을 의미하지 않습니다. 코드를
빌드하여 사용하실 분은 **개인의 책임 하에 특허법을 반드시 준수**해주시기
바랍니다.

## 프로젝트에 대해

### 실사용이 가능한가요?

이 프로젝트는 아직 만들어나가고 있는 미완성 프로젝트입니다. 실사용을 권장하지
않으며, 실사용이 가능해질 정도로 개발이 진행된 경우 이 문서에 업데이트하도록
하겠습니다.

### 어떻게 사용할 수 있나요?

[Android Studio][3]를 설치하신 후 이 프로젝트를 직접 빌드하여 사용하실 수
있습니다. 빌드 또는 사용하시기 전에 [특허에 대하여](#특허에-대하여) 섹션을
반드시 읽어주세요.

### 기여는 어떻게 할 수 있나요?

기여는 언제나 환영입니다! 이 프로젝트는 모아키 및 쿼티 키보드의 기본적인 동작을
안정적으로 구현하는 것을 목표로 하고 있기 때문에, 이에 대한 기여를 받고
싶습니다. 기본적인 동작이 모두 구현된 이후에는 이모지 입력기나 자동 완성과 같은
구글 플레이 배포본에서 구현되지 않았던 최신 입력기의 기능을 구현하려고 합니다.
모아키의 기본적인 동작에서 크게 벗어난 완전히 새로운 입력 방법을 구현하는 것은
현재로서는 목표가 아님을 이해해주시기 바랍니다.

[1]: https://www.youtube.com/watch?v=Mcz0sSz1Ky4
[2]: https://doi.org/10.8080/1020110078022
[3]: https://developer.android.com/studio