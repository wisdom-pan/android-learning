
# git基本操作
常用命令：
* git clone
* git push
* git add
* git commit
* git checkout
* git pull

## 创建仓库
    #初始化git仓库
    git init 

    #新建目录，初始化git仓库
    git init [project-name]

    #下载整个仓库
    git clone

## 信息配置

    #查看当前的git配置
    git global --list

    #编辑git配置信息
    git config --global -e

    #查看git配置信息
    git config --global -l
        
    #关联远程仓库
    git remote add origin [address]
    
 
## 提交修改

    #查看当前仓库状态
    git status

    #查看文件修改记录
    git diff file

    #查看git配置信息
    git add file
    
    #提交所有文件
    git add .
    #推送到远程仓库
    git push origin [分支名]
    

## 撤销提交
git reset
## 撤销远程提交
git reset --soft
## 版本回退
git reset
git remote
# 分支管理
## 合并分支
## 分支冲突

