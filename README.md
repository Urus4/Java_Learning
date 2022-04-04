# Java-Learning
Practice about embedded system and programming

깃 사용하는 방법

1) 설치 후 github와 연결할 폴더 우클릭 - 'Git Bash here'
2) &git config --global user.name "[깃허브 아이디]"
3) &git config --global user.email "[깃허브 가입했던 이메일]"
4) $git init
5) $git remote add origin [레파지토리 주소]
  remote origin already exists에러는 기존에 연결되어 있는 레파지토리가 다시 새로운 레파지토리에 소스코드를 올리려고 하면 발생되는 에러
 5-1) git remote remove origin ---> 기존에 연결되어있는 원격 저장소와의 연결을 끊어줌
 5-2) 다시 5번 입력
 5-3) git remote -v ----> 로컬 저장소를 원격 저장소에 연결시켜줌
 5-4) git push origin master 명령어를 입력해서 소스코드 올리기
 
------
6) $git status
7) git add '트랙킹할 파일' or git add . // 폴더에 존재하는 파일 모두 트렉킹
8) git commit -m "커밋 메시지" 
9) git push origin master  // master란 branch에 push
10) git origin master      // master란 branch에서 pull
