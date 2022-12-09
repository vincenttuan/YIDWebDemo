-- 訊息種類
create table if not exists category (
    id int not null AUTO_INCREMENT, -- 主鍵(category序號)
    name varchar(50) not null unique, -- 種類名稱
    primary key (id)
);

-- 建立留言板
create table if not exists guestbook (
    id int not null AUTO_INCREMENT, -- 主鍵(guestbook序號)
    category_id int not null, -- (訊息種類 id)
    username varchar(50) not null, -- (使用者姓名)
    email varchar(250), -- (使用者email)
    message varchar(500), -- (留言內容)
    updatetime timestamp, -- (修改時間)
    createtime timestamp default current_timestamp, -- (建檔時間)
    primary key (id),
    foreign key (category_id) references category(id) -- 外鍵(category id)
);



