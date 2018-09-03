from django.shortcuts import render, get_object_or_404
from .models import Article
from django.utils import timezone

def article_list(request):
    articles = Article.objects.filter(
            published_date__lte=timezone.now()).order_by('-published_date')
            
    return render(request, 'bord/article_list.html', {'articles':articles})

def article_detail(request, pk):
    article = get_object_or_404(Article, pk=pk)
    return render(request, 'bord/article_detail.html', {'article': article})
