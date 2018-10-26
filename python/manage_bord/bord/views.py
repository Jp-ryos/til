from django.shortcuts import render, get_object_or_404
from .models import Article, Less
from .forms import LessForm
from django.utils import timezone

def article_list(request):
    articles = Article.objects.filter(
            published_date__lte=timezone.now()).order_by('-published_date')
            
    return render(request, 'bord/article_list.html', {'articles':articles})

def article_detail(request, pk):
    article = get_object_or_404(Article, pk=pk)
    return render(request, 'bord/article_detail.html', {'article': article})

def add_less_to_article(request, pk):
    """
    model = Less
    form_class = LessForm 
    templete = 'bord/article_detail.html'
    isSuccess = "/"
    """
    post = get_object_or_404(Article, pk=pk)
    if request.method == "POST":
        form = LessForm(request.POST)
        if form.is_valid():
            less = form.save(commit=False)
            less.article = article
            less.save()
            return redirect('article.detail', pk=article.pk)
    else:
        form = LessForm()
    return render(request, 'bord/article_detail.html', {'form': form})
