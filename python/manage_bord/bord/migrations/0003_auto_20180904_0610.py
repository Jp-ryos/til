# Generated by Django 2.1.1 on 2018-09-04 06:10

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    dependencies = [
        ('bord', '0002_article_text'),
    ]

    operations = [
        migrations.AddField(
            model_name='less',
            name='less',
            field=models.ForeignKey(default=0, on_delete=django.db.models.deletion.DO_NOTHING, to='bord.Article'),
        ),
        migrations.AlterField(
            model_name='less',
            name='author',
            field=models.CharField(max_length=100),
        ),
    ]
