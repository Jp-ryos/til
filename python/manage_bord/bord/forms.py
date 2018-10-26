from django import forms
from .models import Article, Less

class LessForm(forms.ModelForm):
    class Meta:
        model = Less
        fields = ('author', 'text',)
