from django.db import models
from django.utils import timezone

class Article(models.Model):
    author = models.ForeignKey(
            'auth.User',
            on_delete=models.DO_NOTHING
            )
    title = models.CharField(max_length=100)
    text = models.TextField(default="Hello World")
    created_date = models.DateTimeField(
            default=timezone.now
            )
    published_date = models.DateTimeField(
            blank=True,
            null=True
            )

    def publish(self):
        self.publishd_date = timezone.now()
        self.save()

    def __str__(self):
        return self.title

class Less(models.Model):
    author = models.ForeignKey(
            'bord.Article',
            on_delete=models.DO_NOTHING
            )
    text = models.TextField()
    created_date = models.DateTimeField(
            default=timezone.now
            )
    publishd_date = models.DateTimeField(
            blank=True,
            null=True
            )
    approved_comment = models.BooleanField(default=False)

    def applove(self):
        self.apploved_comment = True
        self.save()

    def __str__(self):
        return self.text
