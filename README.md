1. Используйте команды операционной системы Linux и создайте две новых директории – «Игрушки для школьников» и «Игрушки для дошколят»
	

	mkdir test
	cd test/
	mkdir 'Игрушки для школьников'
	cd ..
	mkdir 'Игрушки для дошколят'
	

	2. Создайте в директории «Игрушки для школьников» текстовые файлы - «Роботы», «Конструктор», «Настольные игры»
	

	cd  'Игрушки для школьников'/ && touch > Роботы Конструктор Настольные\ игры
	
	

	3. Создайте в директории «Игрушки для дошколят» текстовые файлы «Мягкие игрушки», «Куклы», «Машинки»
	

	cd ..
	cd 'Игрушки для дошколят'/ && touch > Мягкие\ игрушки Куклы Машинки
	
	

	4. Объединить 2 директории в одну «Имя Игрушки»
	

	cd ..
	mkdir Имя\ игрушки
	cp -R ~/test/Игрушки\ для\ школьников/* ~/test/Имя\ игрушки/
	rm -R ~/test/Игрушки\ для\ школьников/
	cp -R ~/test/Игрушки\ для\ дошколят/* ~/test/Имя\ игрушки/ && rm -R ~/test/Игрушки\ для\ дошколят/
	cd Имя\ игрушки/ 


	5. Переименовать директорию «Имя Игрушки» в «Игрушки»
	

	cd ..
	mv ~/test/Имя\ игрушки/ ~/test/Игрушки

	

	6. Просмотреть содержимое каталога «Игрушки».
	

	cd Игрушки/ && ls -la
	

	
	

	7. Установить и удалить snap-пакет. (Любой, какой хотите)
	

	su
	snap find chromium
	snap install chromium && snap remove chromium
	snap list
	

	
	

	8. Добавить произвольную задачу для выполнения каждые 3 минуты (Например, запись в текстовый файл чего-то или копирование из каталога А в каталог Б).
	

	crontab -l (посмотреть текущие задания пользователя)
	crontab -e (добавить задание - пропишем */3 * * * *
	usr/local/bin/script.sh)
	usr/local/bin/script.sh (создадим и пропишим скрипт)
	#!/bin/bash
	echo $(date) >> /var/log/testcron.log
	sudo chmod ugo+x /usr/local/bin/script.sh
	crontab -l (посмотреть текущие задания пользователя)
	sudo cat /var/log/syslog | grep CRON (показать логи)
	crontab -r (удолить все задачи)
	

